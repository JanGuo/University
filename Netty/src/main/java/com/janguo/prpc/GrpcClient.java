package com.janguo.prpc;

import com.janguo.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrpcClient {
    private static final Logger logger =
            Logger.getLogger(GrpcClient.class.getName());

    private final ManagedChannel channel;
    private final StudentServiceGrpc.StudentServiceBlockingStub blockingStub;
    private final StudentServiceGrpc.StudentServiceStub stub;

    public GrpcClient(String host, int port){
        channel = ManagedChannelBuilder.forAddress(host,port).usePlaintext().build();
        blockingStub = StudentServiceGrpc.newBlockingStub(channel);
        stub = StudentServiceGrpc.newStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void greet(String name){
        logger.info("Will try to greet" + name + "...");
        MyRequest myRequest = MyRequest.newBuilder().setUsername(name).build();

        MyResponse response;

        try {
            // This enables compression for requests. Independent of this setting, servers choose whether
            // to compress responses.
            response= blockingStub.withCompression("gzip").getRealNameByUsername(myRequest);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        }
        logger.info("Greeting: " + response.getRealname());
    }

    public Iterator<StudentResponse> greetByAge(int age){
        logger.info("Will get Students By Age="+age+ "岁");
        StudentRequest studentRequest = StudentRequest.newBuilder().setAge(age).build();
        Iterator<StudentResponse> studentsIterator;

        try {
            studentsIterator = blockingStub.withCompression("gzip").getStudentsByAge(studentRequest);
        }catch (StatusRuntimeException e){
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return null;
        }
        return studentsIterator;
    }

    public void greetByAgeFromStreamRequest(int age){
        StudentRequest studentRequest1 = StudentRequest.newBuilder().setAge(age).build();
        StudentRequest studentRequest2 = StudentRequest.newBuilder().setAge(20).build();
        StreamObserver<StudentRequest> studentRequestStreamObserver = stub.getStudentsWrapperByAges(new StreamObserver<StudentResponseList>() {
            final int[] count = {0};
            @Override
            public void onNext(StudentResponseList value) {
                count[0]++;
                value.getStudentResponseList().forEach(studentResponse -> {
                    logger.info("服务器返回的ListStudent之一： " + studentResponse.toString());
                    System.out.println("---------------");
                });
                logger.info("Response的Next调用次数 " + count[0]);
            }

            @Override
            public void onError(Throwable t) {
                logger.info(t.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("Response OnCompleted!");
            }
        });
        studentRequestStreamObserver.onNext(studentRequest1);
        studentRequestStreamObserver.onNext(studentRequest2);
        studentRequestStreamObserver.onCompleted();
    }



    public void greetByStreamRequest(String s){
        StreamRequest build = StreamRequest.newBuilder().setRequestInfo(s).build();
        StreamRequest build2 = StreamRequest.newBuilder().setRequestInfo(s).build();

        StreamObserver<StreamRequest> requestStreamObserver = stub.bilateralStreamTalk(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                String responseInfo = value.getResponseInfo();
                logger.info("服务器返回的UUID：" + responseInfo);
            }

            @Override
            public void onError(Throwable t) {
                logger.info(t.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("Completed!");
            }
        });

        requestStreamObserver.onNext(build);
        requestStreamObserver.onNext(build2);
        requestStreamObserver.onCompleted();
    }

    public static void main(String[] args) throws InterruptedException {
        String host = "localhost";
        int port = 8899;
        GrpcClient grpcClient = new GrpcClient(host, port);

        try {
            String user = "world";
            // Use the arg as the name to greet if provided
            if (args.length > 0) {
                user = args[0];
            }
             grpcClient.greet("JanGuo");


//            Iterator<StudentResponse> responseIterator = grpcClient.greetByAge(25);
//            for (Iterator<StudentResponse> it = responseIterator; it.hasNext(); ) {
//                StudentResponse response = it.next();
//                System.out.println(response);
//            }

//            grpcClient.greetByAgeFromStreamRequest(25);

            //grpcClient.greetByStreamRequest("Client001");

            Thread.sleep(2000);
        } finally {
            grpcClient.shutdown();
        }


    }

}
