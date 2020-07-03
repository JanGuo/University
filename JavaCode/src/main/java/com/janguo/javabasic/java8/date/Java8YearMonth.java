package com.janguo.javabasic.java8.date;


import java.time.LocalDate;
import java.time.MonthDay;
import java.time.YearMonth;

public class Java8YearMonth {
    public static void main(String[] args) {
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);

        System.out.println(yearMonth.lengthOfYear());
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println("是否是闰年"+yearMonth.isLeapYear());

        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);

        System.out.println(monthDay.getDayOfMonth());
        LocalDate localDate = monthDay.atYear(2020);
        System.out.println(localDate);
        System.out.println(monthDay.getMonth());
        System.out.println(monthDay.getMonthValue());
        MonthDay monthDay1 = MonthDay.of(5, 12);
        System.out.println(monthDay.isAfter(monthDay1));
        System.out.println(monthDay1.isBefore(monthDay));

        MonthDay monthDay2 = MonthDay.of(2, 29);
        System.out.println(monthDay2.isValidYear(2019)); // 检查月日是否在某年有效



    }
}
