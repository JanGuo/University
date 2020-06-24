package com.janguo.javabasic.concurrent.jucutils.aqs.example3;

import java.util.ArrayList;
import java.util.List;

public class DateLoader {

    public static List<Table> capture(Event event) {
        List<Table> tableList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            tableList.add(new Table("Table-" + event.gerId() + "-" + i, i * 1000));
        }

        return tableList;
    }
}
