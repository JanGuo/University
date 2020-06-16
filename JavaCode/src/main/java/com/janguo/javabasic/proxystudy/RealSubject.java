package com.janguo.javabasic.proxystudy;

public class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("From RealSubject request doing");
    }
}
