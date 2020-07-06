package com.janguo.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteTest0 {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            buffer.writeByte(i);
        }

//        for (int i = 0; i < 10; i++) {
//            // 绝对方法 不会改变readIndex
//            System.out.println(buffer.getByte(i));
//        }
        for (int i = 0; i < buffer.capacity(); i++) {
            //  相对方法 改变readIndex的值
            System.out.println(buffer.readByte());
        }
    }
}
