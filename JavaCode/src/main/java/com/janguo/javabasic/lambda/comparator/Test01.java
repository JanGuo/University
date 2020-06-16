package com.janguo.javabasic.lambda.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("nihao", "hello", "world", "welcome");

//        Collections.sort(strings, Comparator.comparingInt(String::length).reversed().thenComparing(String.CASE_INSENSITIVE_ORDER));

//        Collections.sort(strings,Comparator.comparingInt(String::length).reversed().
//                thenComparing(Comparator.comparing(String::toLowerCase)));//welcome
//                                                                            hello
//                                                                            nihao
//                                                                            world

//        Collections.sort(strings,Comparator.comparingInt(String::length).reversed().
//                thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));welcome
//                                                                                                    world
//                                                                                                    nihao
//                                                                                                    hello
        Collections.sort(strings, Comparator.comparingInt(String::length).reversed().
                thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder())));

        strings.forEach(System.out::println);
    }
}
