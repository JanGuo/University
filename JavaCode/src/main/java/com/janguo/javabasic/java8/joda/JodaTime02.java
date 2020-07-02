package com.janguo.javabasic.java8.joda;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.util.Date;

public class JodaTime02 {

    // 标准UTC时间 2020-11-04T09:22:54.865Z

    public static Date convertUTCToDate(String utcDate) {
        DateTime dateTime = null;
        try {
            dateTime = DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
            return dateTime.toDate();
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertToUTC(Date javaDate){

        DateTime dateTime = new DateTime(javaDate, DateTimeZone.UTC);
        return dateTime.toString();
    }

    public static String convertToStringByDateFormat(Date javaDate,String dateFormat){
        DateTime dateTime = new DateTime(javaDate);
        return dateTime.toString(dateFormat);
    }

    public static void main(String[] args) {
        System.out.println(JodaTime02.convertUTCToDate("2020-11-04T09:22:54.865Z"));
        // Wed Nov 04 17:22:54 CST 2020 东八区加八小时
        System.out.println(JodaTime02.convertToUTC(new Date()));
        // 2020-07-02T15:12:29.860Z     东八区减八小时
        Date date = new DateTime(new Date()).plusHours(8).toDate();
        System.out.println(JodaTime02.convertToUTC(date));

        System.out.println(JodaTime02.convertToStringByDateFormat(new Date(), "yyyy-MM-dd"));
    }
}
