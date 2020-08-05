package com.janguo.javabasic.jvmcode;

/*
讲解关于类加载与初始化的相关内容
列举类的主动使用 方法之一 利用反射机制创建类
和讲解是龙loadclass方法  不是对类的直接使用不会导致类的初始化
 */
public class JvmText03 {
    public static void main(String[] args) throws Exception{
        // 说明使用systemclassloder类的loadclass方法加载一个类，不是对类的主动使用，不会导致类的初始化
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz1 = classLoader.loadClass("jvmcode.CL");
        System.out.println(clazz1);
        System.out.println("-----------");
        Class<?> clazz2 = Class.forName("jvmcode.CL");
        System.out.println(clazz2);
        Integer integer = new Integer(1);
        System.out.println(integer instanceof  Integer);//true


        System.out.println(clazz2.newInstance() instanceof  CL);

        while (clazz2.newInstance() instanceof CL)
        {

        }
        for (int i=0;clazz2.newInstance() instanceof CL;i++){
            
        }
            /*
        运行结果
        class jvmcode.CL
        -----------
        jvmcode.CL static block
        class jvmcode.CL
         */
    }
}

class CL{
    static{
        System.out.println("jvmcode.CL static block");
    }
}

