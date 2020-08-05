package com.janguo.javabasic.jvmcode;

public class ClazzLoder {
    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("------");//null  是因为根类加载器是NULL 所以输出NULL

        ClazzLoder[] clazzLoders = new ClazzLoder[2];
        System.out.println(clazzLoders.getClass().getClassLoader());
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        //输出的是系统类加载器（应用类加载器）
        System.out.println("-------");
        int[] a = new int[2];
        System.out.println(a.getClass().getClassLoader());
        //null 原生数组类型没有类加载器所以输出null
        /*
        从ClassLoder类中的说明可知
        Class objects for array classes are not created by class loaders, but are created automatically as required by the Java runtime.
        The class loader for an array class, as returned by Class.getClassLoader() is the same as the class loader for its element type;
        if the element type is a primitive type, then the array class has no class loader.
         */
    }
}
