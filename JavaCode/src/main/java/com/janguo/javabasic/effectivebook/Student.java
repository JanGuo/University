package com.janguo.javabasic.effectivebook;

/**
 * 构建器（Builder）
 */
public class Student {
    private final String fat;
    private String name;
    private int age;
    private String address;


    public static class Builder{
        private final String fat;

        private String name = null;
        private int age = 0;
        private String address = null;

        public Builder(String fat){
            this.fat = fat;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public Student build(){
            return new Student(this);
        }

    }

    public Student(Builder builder){
        this.fat = builder.fat;
        this.address = builder.address;
        this.name = builder.name;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fat=" + fat +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Builder builder = new Builder("high");
//        Student student = builder.setName("JanGuo").setAge(18).setAddress("Beijing").build();
        Student student = builder.setName("JanGuo").setAge(18).build();
        System.out.println(student);
    }

}
