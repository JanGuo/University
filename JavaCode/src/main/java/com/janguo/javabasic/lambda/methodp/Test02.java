package com.janguo.javabasic.lambda.methodp;

import java.util.stream.Stream;

public class Test02 {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.iterate(1, (item) -> item + 2).limit(6);

        System.out.println(integerStream.filter(item -> item > 2).mapToInt(i -> i * 2).skip(2).limit(2).sum());
    }
}
