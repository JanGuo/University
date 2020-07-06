package com.janguo.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class HandleLongToStringDecode extends MessageToMessageDecoder<Long> {
    @Override
    protected void decode(ChannelHandlerContext ctx, Long msg, List<Object> out) throws Exception {
        System.out.println("HandlerLongToStringDecode Invoke!");
        out.add(String.valueOf(msg));
    }
}
