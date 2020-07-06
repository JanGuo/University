package com.janguo.netty.second;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    Map<String,Channel> channels= new HashMap<String, Channel>();
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(this);
        ExecutorService executorService  = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            channels.put(UUID.randomUUID().toString(),ctx.channel());
            channels.entrySet().forEach(stringChannelEntry -> {
                System.out.println(Thread.currentThread().getName());
                System.out.println(stringChannelEntry.getKey() + stringChannelEntry.getValue());
            });
        });
        ctx.channel().eventLoop().execute(() ->{
            System.out.println("你好");
        });
        System.out.println(ctx.channel().remoteAddress() + "," + msg);
        ctx.channel().writeAndFlush("From Server:" + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
