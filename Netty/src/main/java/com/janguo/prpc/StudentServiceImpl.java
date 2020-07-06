package com.janguo.prpc;

import com.janguo.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;
import java.util.logging.Logger;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    private static final Logger logger =
            Logger.getLogger(StudentServiceImpl.class.getName());

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端发来的获取真实姓名的信息：\n \r原信息--->" + request.getUsername());
        MyResponse student = MyResponse.newBuilder().setRealname(request.getUsername().toUpperCase()).build();
        responseObserver.onNext(student);
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接收到客户端发来的获取年龄的信息：\n \r原信息--->Age：" + request.getAge());
        StudentResponse response1 = StudentResponse.newBuilder().setName("Name001").setAge(request.getAge()).setCity("北京").build();
        StudentResponse response2 = StudentResponse.newBuilder().setName("Name002").setAge(request.getAge()).setCity("天津").build();
        StudentResponse response3 = StudentResponse.newBuilder().setName("Name003").setAge(request.getAge()).setCity("重庆").build();
        StudentResponse response4 = StudentResponse.newBuilder().setName("Name004").setAge(request.getAge()).setCity("上海").build();

        responseObserver.onNext(response1);
        responseObserver.onNext(response2);
        responseObserver.onNext(response3);
        responseObserver.onNext(response4);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {

            StudentRequest studentRequest;
            int requestAge;

            @Override
            public void onNext(StudentRequest value) {
                requestAge = value.getAge();
                logger.info("OnNext: " + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                logger.info("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("OnCompleted!");

                StudentResponse studentResponse1 = StudentResponse.newBuilder().setName("List-1-Name001").setAge(requestAge).setCity("北京").build();
                StudentResponse studentResponse2 = StudentResponse.newBuilder().setName("List-1-Name002").setAge(requestAge).setCity("天津").build();
                StudentResponse studentResponse3 = StudentResponse.newBuilder().setName("List-1-Name003").setAge(requestAge).setCity("上海").build();
                StudentResponse studentResponse4 = StudentResponse.newBuilder().setName("List-1-Name004").setAge(requestAge).setCity("重庆").build();

                StudentResponseList studentResponseList = StudentResponseList.newBuilder().addStudentResponse(studentResponse1).addStudentResponse(studentResponse2)
                        .addStudentResponse(studentResponse3).addStudentResponse(studentResponse4).build();

                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> bilateralStreamTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            String requestInfo;

            @Override
            public void onNext(StreamRequest value) {
                requestInfo = value.getRequestInfo();
                logger.info("OnNext: " + value.getRequestInfo());

                StreamResponse streamResponse = StreamResponse.newBuilder().setResponseInfo("Server:-->" + UUID.randomUUID()).build();
                responseObserver.onNext(streamResponse);
            }

            @Override
            public void onError(Throwable t) {
                logger.info("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("OnCompleted!");
                responseObserver.onCompleted();
            }
        };
    }
}
