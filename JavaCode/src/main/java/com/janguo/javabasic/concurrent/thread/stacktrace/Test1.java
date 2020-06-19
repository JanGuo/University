package com.janguo.javabasic.concurrent.thread.stacktrace;


public class Test1 {
    public void run(){
        Test2 test2 = new Test2();
        test2.run();
    }
}
