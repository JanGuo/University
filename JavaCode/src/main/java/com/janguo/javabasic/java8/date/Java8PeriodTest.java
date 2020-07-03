package com.janguo.javabasic.java8.date;

import java.time.LocalDate;
import java.time.Period;

/**
 * Period n. 周期，期间；时期；一段时间；经期；课时；句点，句号
 *        adj. 某一时代的
 *
 *
 */
public class Java8PeriodTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2019, 7, 15);
        Period period = Period.between(localDate1, localDate);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        /*
        0
        11
        18  输出中间间隔了多少个年 多少个月 多少天
         */
    }
}
