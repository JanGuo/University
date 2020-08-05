package com.janguo.javabasic.jvmcode;

import java.util.Arrays;
import java.util.List;

public class ArgsTest {
    public static void main(String[] args) {
        System.out.println(ArgsTest.sum(11, 12, 12, 125));
        List<Integer> integers = Arrays.asList(1, 2);
        System.out.println(integers);
    }
    public static int sum(int... a){
        int sum = 0;
        for (int az:a){
            sum +=az;
        }
        return sum;
    }
}
