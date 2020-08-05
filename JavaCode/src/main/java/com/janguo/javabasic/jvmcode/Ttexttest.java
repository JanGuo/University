package com.janguo.javabasic.jvmcode;

public class Ttexttest
{
    public static void main(String[] args) {
        Ttext<Integer> stringTtext = new Ttext<Integer>();
        stringTtext.setObj(new Integer(20));
        Integer obj = stringTtext.getObj();
        System.out.println(obj);
        Ttext<String> stringTtext1 = new Ttext<String>();
        stringTtext1.setObj(new String("张三"));
        System.out.println(stringTtext1.getObj());
    }
}
