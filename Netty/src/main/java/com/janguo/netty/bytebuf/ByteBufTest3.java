package com.janguo.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Iterator;

public class ByteBufTest3 {
    public static void main(String[] args) {
        CompositeByteBuf compositeByteBuf = Unpooled.compositeBuffer();

        ByteBuf heapBuf = Unpooled.buffer();
        ByteBuf directBuffer = Unpooled.directBuffer();

        System.out.println(heapBuf.maxCapacity());
        compositeByteBuf.addComponents(heapBuf,directBuffer);

        Iterator<ByteBuf> iterator = compositeByteBuf.iterator();

//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        compositeByteBuf.forEach(System.out::println);
    }
}
