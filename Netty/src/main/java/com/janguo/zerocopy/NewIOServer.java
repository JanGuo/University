package com.janguo.zerocopy;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {
    public static void main(String[] args) throws Exception{
        InetSocketAddress address = new InetSocketAddress(8899);

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);//端口处于等待状态就可以重新绑定
        serverSocket.bind(address);

        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(true);

        ByteBuffer byteBuffer  = ByteBuffer.allocate(4096);
        while (true){


            int readCount = 0;
            while (readCount != -1){
                readCount = socketChannel.read(byteBuffer);
            }

            byteBuffer.rewind();
        }
    }
}
