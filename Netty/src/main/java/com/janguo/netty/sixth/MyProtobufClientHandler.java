package com.janguo.netty.sixth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class MyProtobufClientHandler extends SimpleChannelInboundHandler<MyDataManyInfo.MyMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataManyInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);

        MyDataManyInfo.MyMessage myMessage = null;
        if (0 == randomInt) {
            MyDataManyInfo.Person person = MyDataManyInfo.Person.newBuilder().setAddress("山东").setAge(25).setName("张三").build();
            myMessage = MyDataManyInfo.MyMessage.newBuilder().
                    setDataType(MyDataManyInfo.MyMessage.DataType.PersonType).
                    setPerson(person).build();
        } else if (1 == randomInt) {
            MyDataManyInfo.Cat cat = MyDataManyInfo.Cat.newBuilder().setName("CAT001").setAge("2").build();
            myMessage = MyDataManyInfo.MyMessage.newBuilder().
                    setDataType(MyDataManyInfo.MyMessage.DataType.CatType).
                    setCat(cat).build();
        } else {
            MyDataManyInfo.Dog dog = MyDataManyInfo.Dog.newBuilder().setName("Dog001").setColour("黄").build();
            myMessage = MyDataManyInfo.MyMessage.newBuilder().
                    setDataType(MyDataManyInfo.MyMessage.DataType.DogType).
                    setDog(dog).build();
        }
        ctx.channel().writeAndFlush(myMessage);


//        MyDataInfo.Person person = MyDataInfo.Person.newBuilder().setName("张三").setAddress("山东").setAge(33).build();
//
//        ctx.channel().writeAndFlush(person);
    }
}
