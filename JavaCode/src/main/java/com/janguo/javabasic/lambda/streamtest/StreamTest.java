package com.janguo.javabasic.lambda.streamtest;


import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world");

        list.stream().map(item -> item).filter(item -> true).forEach(System.out::println);
    }
}
