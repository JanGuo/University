package com.janguo.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NioTest4UpDate {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream("input.txt");
            outputStream = new FileOutputStream("output.txt");
            FileChannel inputChannel = inputStream.getChannel();
            FileChannel outputChannel = outputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            int read = 1;
            // read = -1 正常去读完
            // read = 0  读取结果为空
            while (read !=-1&& read!=0){
                read = inputChannel.read(byteBuffer);
                byteBuffer.flip();
                outputChannel.write(byteBuffer);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (inputStream != null){
                    inputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
