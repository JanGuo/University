package com.janguo.javabasic.jvmcode;

import java.util.ArrayList;

public class ArrArrTest {
    public static void main(String[] args) {
        Student s1 = new Student("张三");
        Student s2 = new Student("李四");
        ArrayList<Student> studentsArrayList = new ArrayList<Student>();
        studentsArrayList.add(s1);
        studentsArrayList.add(s2);

        Teacher t1 = new Teacher("周五");
        Teacher t2 = new Teacher("郑王");

        ArrayList<Teacher> teachersArrayList = new ArrayList<Teacher>();
        teachersArrayList.add(t1);
        teachersArrayList.add(t2);

        ArrayList<ArrayList<? extends Person>> arrayListArrayList = new ArrayList<>() ;
        arrayListArrayList.add(studentsArrayList);
        arrayListArrayList.add(teachersArrayList);

        for (ArrayList<? extends Person> personArrayList :arrayListArrayList){
            for (Person p:personArrayList){
                System.out.println(p.getName());
            }
        }
    }
}

class Student extends Person{
    Student(String name) {
        super(name);
    }
}

class Teacher extends Person{
    Teacher(String name) {
        super(name);
    }
}
