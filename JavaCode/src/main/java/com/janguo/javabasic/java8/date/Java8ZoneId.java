package com.janguo.javabasic.java8.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.TreeSet;

public class Java8ZoneId {

    public static void main(String[] args) {
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        Set<String> treeSet = new TreeSet<String>(){
            {
                addAll(zoneIds);
            }
        };
        treeSet.forEach(System.out::println);
        System.out.println(zoneIds.size());

        System.out.println("------------------");

        ZoneId zoneId = ZoneId.of("Asia/Shanghai");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);



    }
}
