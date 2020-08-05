package com.janguo.javabasic.jvmcode;

public class TInerfaceImpl<T> implements TInterface<T>{

    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
