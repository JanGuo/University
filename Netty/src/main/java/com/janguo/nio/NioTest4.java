package com.janguo.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class NioTest4 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

        FileChannel channel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

       while (true){
           //byteBuffer.clear();
           System.out.println("Channel Read Before Position: " +byteBuffer.position() );
           System.out.println("Channel Read Before Limit: " + byteBuffer.limit());
           System.out.println("Channel Read Before Capacity: " +byteBuffer.capacity() );
           int read = channel.read(byteBuffer);
            //chanel.read()方法 正常读取读取到末尾返回-1 如果读取的内容为大小为0 则返回0
           System.out.println("Read: "+read);
           if (-1 == read|| 0 ==read ){ //将来两种都没有数据可读的可能，全部跳出。
               break;
           }
           System.out.println("Before Position: " +byteBuffer.position() );
           System.out.println("Before Limit: " + byteBuffer.limit());
           System.out.println("Before Capacity: " +byteBuffer.capacity() );
           byteBuffer.flip();
           System.out.println("After Position: " +byteBuffer.position() );
           System.out.println("After Limit: " + byteBuffer.limit());
           System.out.println("After Capacity: " +byteBuffer.capacity() );
           outputStreamChannel.write(byteBuffer);
       }





//        while (byteBuffer.hasRemaining()){
//            System.out.println("Data:" + (char)byteBuffer.get());
//        }

        System.out.println(byteBuffer.limit() == byteBuffer.position());
        fileInputStream.close();
        outputStreamChannel.close();
    }
}
