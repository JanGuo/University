package com.janguo.javabasic.jvmcode;

import java.util.ArrayList;
import java.util.Iterator;

public class ThreeFor {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.add("Say");
        //for遍历
        for (int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println("------------");
        //增强for
        for (String s:arrayList){
            System.out.println(s);
        }
        System.out.println("---------------");

        //迭代器
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);

        }

    }
}
