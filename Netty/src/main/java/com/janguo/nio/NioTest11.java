package com.janguo.nio;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class NioTest11 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(8899);
        serverSocketChannel.socket().bind(address);

        SocketChannel channel = serverSocketChannel.accept();

        int messageLength = 2 + 3 + 4;
        ByteBuffer[] byteBuffers = new ByteBuffer[3];
        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[1] = ByteBuffer.allocate(3);
        byteBuffers[2] = ByteBuffer.allocate(4);

        while (true) {
            int bytesRead = 0;
            while (bytesRead < messageLength) {
                long read = channel.read(byteBuffers);
                bytesRead += read;

                System.out.println("BytesRead: " + bytesRead);

                Arrays.asList(byteBuffers).stream()
                        .map(byteBuffer -> "Position: " + byteBuffer.position() + "Limit: " + byteBuffer.limit())
                        .forEach(System.out::println);
            }

            Arrays.asList(byteBuffers).forEach(Buffer::flip);

            long bytesWritten = 0;
            while (bytesWritten < messageLength) {
                long write = channel.write(byteBuffers);
                bytesWritten += write;
            }
            Arrays.asList(byteBuffers).forEach(Buffer::clear);

            System.out.println("BytesRead: " + bytesRead + "BytesWritten: " + bytesWritten + "BytesMessage: " + messageLength);


        }

    }
}
