package com.janguo.leetcode;

public class Solution07 {

    public static void main(String[] args) {
        int a = 1534236469;
        Solution07 solution07 = new Solution07();
        System.out.println(solution07.reverse(a));
    }

    public int reverse(int x) {
        if (x == 0 || (x < 0 && -x < 0))
            return 0;

        if (x > 0) {
            String string = new StringBuilder(Integer.toString(x)).reverse().toString();
            double d = Double.parseDouble(string);
            if (d>Integer.MAX_VALUE){
                return 0;
            }
            return (int) d;
        }  else {
            int a = Math.abs(x);
            String string = new StringBuilder(Integer.toString(a)).reverse().toString();
            double d = Double.parseDouble(string);
            if (d>Integer.MAX_VALUE){
                return 0;
            }
            return (int) d;
        }
    }

//    public int reverse(int x) {
//        if (x == 0 || (x < 0 && -x < 0))
//            return 0;
//        /*对 输入 0 ，以及 大于Integer.MAX_VALUE
//        和 小于Integer.MIN_VALUE 的情况进行特判，返回值为 0*/
//        int n = deleteZero(x);
//        int c = Math.abs(n); // 将去掉末尾0的数字取绝对值，得c
//        String str = String.valueOf(c); // 将c转换为字符串str
//        StringBuffer sb = new StringBuffer(str); // 将str包装为StringBuffer
//        String key = sb.reverse().toString(); // key存储倒序后的字符串
//        double rev = Double.parseDouble(key); // 解析为double类型数字
//        if (rev > Integer.MAX_VALUE) {
//            return 0; // 大于int范围输出0
//        } else if (x > 0) {
//            return (int) rev; // 将double类型的rev 强制转换为int 返回
//        } else {
//            return (int) (rev * (-1)); // 乘以-1添上负号
//        }
//    }
//
//    static int deleteZero(int n) {
//        // 用 不断除以0 的方式去掉原数字后面的0
//        while (n % 10 == 0) {
//            n = n / 10;
//        }
//        return n;
//    }
}
