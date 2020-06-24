package com.janguo.javabasic.concurrent.jucutils.aqs;

import com.janguo.javabasic.concurrent.jucutils.aqs.example3.*;
import com.janguo.javabasic.concurrent.jucutils.aqs.example3.wacherimpl.TaskBatch;
import com.janguo.javabasic.concurrent.jucutils.aqs.example3.wacherimpl.TaskGroup;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 应用场景3
 *
 * 一个数据库中的数据--通过DateLoader--加载到数据湖中（数据湖的任务 可能有数据的清洗、数据版本控制）之后传给别的机器处理
 * 需要增加一个数据验证的功能， 并且实现将数据的各种字段 分离开来验证来提升验证的效率
 *                           字段1： RecordCount （记录值） DateLoader 处理了多少条数据 存储起来  数据湖可以通过访问存储的数据进行验证
 *                           字段2： Column Schema (列 概要)
 *                           字段3： Size     （数据大小）
 *                           字段4： CheckSum  （检查）  抽样检查 当数据过于庞大的时候，可以进行抽样MD5 检查的方式
 *
 * 验证功能可以通过DateLoader{table1:{RecordCount,Column Schema,Size,CheckSum} , table2:{}, ...table100:{}} 来提交一个事件的方式来实现
 * 并且将每一个字段，封装成不同的任务  交给不同的时间执行器来处理
 *
 * 当一个表的所有字段的检测全部做完之后，将测试结果存储到数据库中（就可以使用CountDownLatch）
 * 当所有的表做完后，通知Event 之间执行完毕 （可以使用CountDownLatch来统计最后是否验证完毕）
 *
 * 有一个组件 用来处理DateLoader提交的事件
 *
 *
 */
public class CountDownLatchExample3 {
    public static void main(String[] args) {
        Event[] events = {new Event(1),new Event(2)};
        List<Event> events1 = Arrays.asList(events);

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        events1.forEach(event -> {
            List<Table> tables = DateLoader.capture(event);
            TaskGroup taskGroup = new TaskGroup(tables.size(), event);
            for (Table table:tables){
                TaskBatch taskBatch = new TaskBatch(2,taskGroup);
                TrustSourceSizeRunnable sizeRunnable = new TrustSourceSizeRunnable(table,taskBatch);
                TrustSourceColumnsSchemaRunnable columnsSchemaRunnable = new TrustSourceColumnsSchemaRunnable(table,taskBatch);

                fixedThreadPool.submit(sizeRunnable);
                fixedThreadPool.submit(columnsSchemaRunnable);
            }
        });


    }
}
