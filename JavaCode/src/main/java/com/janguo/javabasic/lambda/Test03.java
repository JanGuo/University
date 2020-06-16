package com.janguo.javabasic.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Test03 {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 25);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 24);
        Person person4 = new Person("zhengwang", 58);
        Person person5 = new Person("周杰伦", 26);
        Person person6 = new Person("许嵩", 28);
        Person person7 = new Person("汪苏泷", 28);
        Person person8 = new Person("刀郎", 42);
        Person person9 = new Person("刘欢", 52);
        Person person10 = new Person("李玉刚", 35);

        List<Person> persons = Arrays.asList(person1, person2, person3,person4,person5,
                person6,person7,person8,person9,person10);
        Test03 test03 = new Test03();
//        List<Person> person = test03.getPersonByUserName("lisi", persons);
//        person.forEach(person11 -> System.out.println(person11.getAge()));
//        List<Person> personsByAge = test03.getPersonsByAge(25, persons);
//        personsByAge.forEach(person11 -> System.out.println(person11.getName()+person11.getAge()));


        List<Person> personsByAge1 = test03.getPersonsByAge(25, persons, (age, personList) -> {
            return personList.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
        });

        personsByAge1.forEach(person11 -> System.out.println(person11.getName()+person11.getAge()));

    }

    public List<Person> getPersonByUserName(String username,List<Person> persons){
        return persons.stream().filter(person -> person.getName().equals(username)).collect(Collectors.toList());
    }
    public List<Person> getPersonsByAge(int age,List<Person> peoples){
        BiFunction<Integer,List<Person>,List<Person>> biFunction  = (ageOfPerson,personList) -> {
            return personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
        };
        return biFunction.apply(age,peoples);
    }
    public List<Person> getPersonsByAge(int age,List<Person> personList,BiFunction<Integer,List<Person>,List<Person>> biFunction){
        return biFunction.apply(age,personList);
    }


}
