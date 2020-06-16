package com.janguo.javabasic.lambda;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class Text04 {

    public static void main(String[] args) {
        String s1 = "osdwfef";
        String s2 = "bwefweffqwf";

        System.out.println(Text04.getStringByMax(s1, s2, (a, b) -> a.length() - b.length()));
        System.out.println(Text04.getStringByMax(s1, s2, (a, b) -> a.charAt(0) - b.charAt(0)));
    }


    public static String getStringByMax(String s1, String s2, Comparator<String> comparator){
        return BinaryOperator.maxBy(comparator).apply(s1, s2);
    }
}
