package com.janguo.javabasic.lambda.methodp;

public class Student {
    private String name;
    private Integer code;

    public Student(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static int compareByCode(Student s1 , Student s2){
        return s1.getCode()-s2.getCode();
    }
}
