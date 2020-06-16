package com.janguo.leetcode;

public class Solution258 {

    public static void main(String[] args) {
        Solution258 solution258 = new Solution258();
        System.out.println(solution258.addDigits(258));
    }
    public int addDigits(int num) {
        return (num-1)%9+1;

    }
}
