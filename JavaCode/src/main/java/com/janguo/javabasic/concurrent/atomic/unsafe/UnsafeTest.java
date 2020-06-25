package com.janguo.javabasic.concurrent.atomic.unsafe;



import java.lang.reflect.Field;

public class UnsafeTest {

//    public static void main(String[] args) throws IllegalAccessException {
//        // unsafe 无法通过
////    Unsafe.getUnsafe()
//        // 的方法获得
//
//
//        // 这个方法在Java8中也无法获取了
//        Unsafe unsafe = getUnsafe();
//        System.out.println(unsafe);
//    }
//
//    private static Unsafe getUnsafe() throws IllegalAccessException {
//        Field field = null;
//        try {
//             field = Unsafe.class.getDeclaredField("theUnsafe");
//            field.setAccessible(true);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return (Unsafe) field.get(null);
//    }
}
