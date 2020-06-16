package com.janguo.javabasic.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test01 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,5,8,9,7,5,14,12);
        list.forEach(
                (integer) -> System.out.println(integer)
        );

        Consumer c = (i) ->{
            System.out.println(i);
        };

    }

}
