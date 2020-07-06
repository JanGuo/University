package com.janguo.nio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorRemove {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        strings.add("NiHao");
        Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            if ("Hello".equals(s)) {
                iterator.remove();
            }
            System.out.println(s);

        }

        System.out.println(strings);
    }
}
