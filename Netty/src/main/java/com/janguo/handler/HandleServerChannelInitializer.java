package com.janguo.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class HandleServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast(new HandlerDecode());
        pipeline.addLast(new HandleDecode2());
        pipeline.addLast(new HandleLongToStringDecode());
        pipeline.addLast(new HandlerEncode());
        pipeline.addLast(new HandleServerHandler());
    }
}
