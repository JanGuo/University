package com.janguo.zerocopy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {
    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8899));
        socketChannel.configureBlocking(true);

        String fileName = "/Users/janguo/Downloads/Liunx/jdk-8u251-linux-x64.tar.gz";
        FileInputStream inputStream = new FileInputStream(fileName);
        FileChannel fileChannel = inputStream.getChannel();

//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);
//
//        while (true){
//            byteBuffer.clear();
//            fileChannel.read(byteBuffer);
//
//            byteBuffer.flip();
//            socketChannel.write(byteBuffer);
//        }

        long startTime = System.currentTimeMillis();

        // 比上面的循环效率高一点 肯transferTo文档  里面还涉及了一些零拷贝的知识 针对于某中操作系统
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("总发送的字节数：" + transferCount + "，耗时："+ (System.currentTimeMillis()-startTime));
        fileChannel.close();
    }
}
