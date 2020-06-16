package com.janguo.javabasic.lambda;

@FunctionalInterface
interface MyFunctionInterface{
    void test();
    String toString();
}

public class Test02 {
    public void myTest(MyFunctionInterface myFunctionInterface){
        System.out.println(1);
        myFunctionInterface.test();
        System.out.println(2);
    }
    public static void main(String[] args) {
        Test02 test02 = new Test02();
        test02.myTest(() ->{
            System.out.println("From MYFunctionInterface");
        });
        System.out.println("-----------");

        MyFunctionInterface mfi = () -> {
            System.out.println("Hello World");
        };
        System.out.println(mfi.getClass());
        System.out.println(mfi.getClass().getSuperclass());
        System.out.println(mfi.getClass().getInterfaces()[0]);

    }
}
