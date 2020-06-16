package com.janguo.leetcode;

public class Solution01 {
    public static void main(String[] args) {
        String s = "adcasdfgh";
        int num = 0;
        boolean isToEnd = false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length&&!isToEnd; i++) {
            for (int j = 0;j<i;j++){
                if (chars[i]!=chars[j]){
                    num++;
                }else {
                    isToEnd = true;
                    break;
                }
            }

        }
        System.out.println(num);
    }
}
