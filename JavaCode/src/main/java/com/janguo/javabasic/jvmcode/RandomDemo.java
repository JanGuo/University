package com.janguo.javabasic.jvmcode;

import java.util.ArrayList;
import java.util.Random;

/*
获取10个1-20之间的随机数。要求不能重复

数组实现，但是长度是固定的 长度不好确定
所以用集合实现

A ： 创建产生随机数的对象
B：  创建一个存储随机数的数组
C：   定义一个统计变量，用来存储产生随机数的个数
D：   判断统计遍历是否小于10
        是 先产生一个随机数，判断改随机数是否存在
                如果不存在 则添加 统计变量++
                存在 不管
        否   不管
 */
public class RandomDemo {
    public static void main(String[] args) {
        //创建产生随机数的对象
        Random random = new Random();
        //创建一个存储随机数的数组
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        // 定义一个统计变量，用来存储产生随机数的个数
        int count = 0;
        //判断统计遍历是否小于10
        while (count < 10){
            int i = random.nextInt(20)+1;
            if (!integerArrayList.contains(i)){
                integerArrayList.add(i);
                count++;
            }
        }

        for (Integer i:integerArrayList){
            System.out.println(i);
        }
    }
}
