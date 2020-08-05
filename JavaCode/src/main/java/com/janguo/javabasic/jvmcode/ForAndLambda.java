package com.janguo.javabasic.jvmcode;

import java.util.ArrayList;
import java.util.Iterator;

public class ForAndLambda {
    public static void main(String[] args) {
        ArrayList<Person> array = new ArrayList<Person>();
        Person p1 = new Person("Tom1");
        Person p2 = new Person("Tom2");
        Person p3 = new Person("Tom3");
        Person p4 = new Person("Tom4");
        array.add(p1);
        array.add(p2);
        array.add(p3);
        array.add(p4);
        Iterator<Person> iterator = array.iterator();
        /*
        for (jvmcode.Person pp : array) {
            System.out.println(pp.getName());
        }
        System.out.println("\r\n" + "-----利用Lambda表达式的foreach-----" + "\r\n");
        array.forEach(obj -> System.out.println(obj.getName()));

        System.out.println("\r\n" + "-----利用for循环-----" + "\r\n");
        for (jvmcode.Person p : array) {
            p.setName("wang");
        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName()); //输出的是wang，而不是tom } } }
        }
*/
        while (iterator.hasNext()) {
            String name = iterator.next().getName();
            System.out.println(name);
            if (name.equals("Tom3")) {
                //array.remove(name);  //不推荐这种方式

                iterator.remove();
                //array.add(new jvmcode.Person("javaee"));//ConcurrentModificationException
            }
        }
        System.out.println("--------------");
        array.forEach(obj -> System.out.println(obj.getName()));
    }
}