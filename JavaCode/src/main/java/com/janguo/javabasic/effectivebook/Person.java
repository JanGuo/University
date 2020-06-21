package com.janguo.javabasic.effectivebook;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.stream.IntStream;

/**
 * 避免创建不必要的对象
 * 测试 创建不必要对象与不创建时间上的差别
 */
public class Person {

    private final Date birthDate;

    public boolean isBabyBoomer() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();

        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        for (int i = 0; i < 1000000; i++) {
            Person person = new Person(date);
            person.isBabyBoomer();
        }
        System.out.println("不优化的消耗时间"+(System.currentTimeMillis()-start));
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Person1 person = new Person1(date);
            person.isBabyBoomer();
        }
        System.out.println("优化的消耗时间"+(System.currentTimeMillis()-start1));
    }

}

class Person1 {
    private final Date birthDate;

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        System.out.println("STATI");
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }

    public Person1(Date birthDate) {
        this.birthDate = birthDate;
    }
}
