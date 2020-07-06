package com.janguo.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("NioTest2.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        StringBuffer stringBuffer = new StringBuffer();
        while (byteBuffer.hasRemaining()){
            byte b = byteBuffer.get();
            stringBuffer.append((char) b);
            System.out.println("Character:" + (char)b);
        }

        fileInputStream.close();
        System.out.println(stringBuffer);
    }
}
