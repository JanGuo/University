package com.janguo.netty.sixth;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyProtoBufHandler extends SimpleChannelInboundHandler<MyDataManyInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataManyInfo.MyMessage msg) throws Exception {

        MyDataManyInfo.MyMessage.DataType dataType = msg.getDataType();
        if (dataType == MyDataManyInfo.MyMessage.DataType.PersonType){
            MyDataManyInfo.Person person = msg.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getAddress());
            System.out.println(person.getAge());
        }else if (dataType == MyDataManyInfo.MyMessage.DataType.DogType){
            MyDataManyInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getColour());

        }else {
            MyDataManyInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getAge());
        }

        // System.out.println(msg);
    }
}
