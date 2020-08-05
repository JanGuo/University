package com.janguo.javabasic.jvmcode.jvmmemory;

import java.util.ArrayList;

public class MyTest01 {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();

        for (;;){
            objects.add(new Object());
        }
    }
}
