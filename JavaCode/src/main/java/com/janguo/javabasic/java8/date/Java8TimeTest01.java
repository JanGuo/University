package com.janguo.javabasic.java8.date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

public class Java8TimeTest01 {
    public static void main(String[] args) {

        // 不关注 时间 只关注年月日
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.getYear() +","+ date.getMonthValue() +","+ date.getDayOfMonth());
        LocalDate date1 = LocalDate.of(2020, 11, 20);
        System.out.println(date1);

        System.out.println("--------------");
        LocalDate date2 = LocalDate.of(2010, 3, 25);

        // 不关注 年
        MonthDay monthDay = MonthDay.of(date2.getMonth(), date2.getDayOfMonth());
        MonthDay monthDay1 = MonthDay.from(LocalDate.of(2010, 3, 25));

        if (monthDay.equals(monthDay1)){ // 对equals重写了
            System.out.println("equals");
        }else {
            System.out.println("No");
        }

        // 只关注 时间 小时 分钟秒
        LocalTime time = LocalTime.now();
        System.out.println(time);

        System.out.println(time.plusHours(3).plusMinutes(30));
    }
}
