package com.janguo.javabasic.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Java8TimeTest02 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        LocalTime localTime = time.plus(2, ChronoUnit.MICROS);
        System.out.println(localTime);

        LocalDate date = LocalDate.now();
        LocalDate localDate = date.minus(2, ChronoUnit.WEEKS);
        System.out.println(localDate);

        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime localDateTime = dateTime.plus(2, ChronoUnit.WEEKS).minus(2, ChronoUnit.MICROS);
        System.out.println(localDateTime);



        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2011, 11, 20);

        System.out.println(date1.isAfter(date2));
        System.out.println(date2.isBefore(date1));

        System.out.println(!date2.isEqual(date1));

        System.out.println(!date2.equals(date1));

    }
}
