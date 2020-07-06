package com.janguo.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class HandlerDecode extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        System.out.println("Decode Invoke!");
        System.out.println(in.readableBytes());
        if (in.readableBytes() >= 8){
            out.add(in.readLong());
        }
    }
}
