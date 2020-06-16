package com.janguo.javabasic.lambda.methodp;

import java.util.Arrays;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        Student z1 = new Student("z1", 50);
        Student z2 = new Student("z2", 80);
        Student z3 = new Student("z3", 30);
        Student z4 = new Student("z4", 57);
        Student z5 = new Student("z5", 10);
        Student z6 = new Student("z6", 25);
        Student z7 = new Student("z7", 47);
        Student z8 = new Student("z8", 45);
        List<Student> students = Arrays.asList(z1, z2, z3, z4, z5, z6, z7, z8);

        students.sort(Student::compareByCode);

        students.forEach(item -> System.out.println(item.getCode()));
    }
}
