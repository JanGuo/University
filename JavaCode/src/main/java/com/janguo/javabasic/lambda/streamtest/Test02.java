package com.janguo.javabasic.lambda.streamtest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test02 {
    public static void main(String[] args) {
        Student s1 = new Student("s", 100);
        Student s2 = new Student("l", 90);
        Student s3 = new Student("w", 90);
        Student s4 = new Student("s", 80);

        List<Student> students = Arrays.asList(s1, s2, s3, s4);

//        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));

//        Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getScore));

//        Map<String, Long> map = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

//        Map<String, Double> map = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));

        Map<Boolean, List<Student>> map = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 90));//分区
        System.out.println(map);

    }
}
