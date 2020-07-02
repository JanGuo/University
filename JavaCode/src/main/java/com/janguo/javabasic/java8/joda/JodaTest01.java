package com.janguo.javabasic.java8.joda;

import org.joda.time.DateTime;

public class JodaTest01 {
    public static void main(String[] args) {
        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);

        System.out.println(today.toString("yyyy-MM-dd"));
        System.out.println(tomorrow.toString("yyyy-MM-dd"));

        DateTime d1 = today.withDayOfMonth(1);
        System.out.println(d1);
        DateTime localDate = new DateTime();

        DateTime date = localDate.plus(3).dayOfMonth().withMinimumValue();
        System.out.println(date);


        DateTime dateTime = localDate.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMaximumValue();
        System.out.println(dateTime);


    }
}
