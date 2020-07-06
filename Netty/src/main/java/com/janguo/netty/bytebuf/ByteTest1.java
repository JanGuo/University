package com.janguo.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.StandardCharsets;

public class ByteTest1 {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.copiedBuffer("你Hello World", StandardCharsets.UTF_8);
        if (buffer.hasArray()){
            byte[] array = buffer.array();

            String string = new String(array, StandardCharsets.UTF_8);
            System.out.println(string);

            System.out.println(buffer);

            // 第一个字符的偏移量
            System.out.println(buffer.arrayOffset());
            System.out.println(buffer.readerIndex());
            System.out.println(buffer.writerIndex());
            // ByBuf 的总长度
            System.out.println(buffer.capacity());
            // 可读字节数
            System.out.println(buffer.readableBytes());

            for (int i = 0; i < buffer.readableBytes(); i++) {
                 System.out.print((char) buffer.getByte(i));
//                System.out.println((char)buffer.readByte());
            }

            System.out.println(buffer.readerIndex());


            System.out.println(buffer.getCharSequence(0, 4, StandardCharsets.UTF_8));
            System.out.println(buffer.readerIndex());

        }

    }
}
