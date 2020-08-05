package com.janguo.javabasic.jvmcode;

import java.util.ArrayList;
import java.util.Collection;

public class THigh {
    public static void main(String[] args) {
        //范型前后类型必须相同
        Collection<Object> c1 = new ArrayList<Object>();
//        Collection<Object> c2 = new ArrayList<jvmcode.Animal>();
//        Collection<Object> c3 = new ArrayList<jvmcode.Dog>();
//        Collection<Object> c4 = new ArrayList<jvmcode.Cat>();

        //? 通配符
        Collection<?> c5 = new ArrayList<Object>();
        Collection<?> c6 = new ArrayList<Animal>();
        Collection<?> c7 = new ArrayList<Dog>();
        Collection<?> c8 = new ArrayList<Cat>();

        // ? extends jvmcode.Animal 自己与子类
        //Collection<? extends jvmcode.Animal> c9 = new ArrayList<Object>();
        Collection<? extends Animal> c11 = new ArrayList<Animal>();
        Collection<? extends Animal> c12 = new ArrayList<Dog>();
        Collection<? extends Animal> c13 = new ArrayList<Cat>();

        //? super jvmcode.Animal  自己与子类
        Collection<? super Animal> c14 = new ArrayList<Object>();
        Collection<? super Animal> c15 = new ArrayList<Animal>();
//        Collection<? super jvmcode.Animal> c16 = new ArrayList<jvmcode.Dog>();
//        Collection<? super jvmcode.Animal> c17 = new ArrayList<jvmcode.Cat>();

    }
}

class Animal{

}

class Dog extends Animal{

}

class Cat extends Animal{

}
