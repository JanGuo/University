package com.janguo.protobuf;

public class ProtoBufTest {
    public static void main(String[] args) throws Exception{
        DataInfo.Student.Builder builder = DataInfo.Student.newBuilder();
        DataInfo.Student student = builder.setName("张三").setAge(20).setAddress("北京").build();

        byte[] studentByteArray = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(studentByteArray);
        System.out.println(student1);
        System.out.println(student1.getName());

    }
}
