package com.janguo.leetcode;

import java.util.HashSet;

public class Solution202 {

    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        System.out.println(solution202.getNext(22));
        System.out.println(solution202.isHappy(243));
    }

    public int getNext(int a) {
        int sum = 0;
        while (a > 0) {

            int m = a % 10;
            a = a / 10;
            sum += (m * m);
        }
        return sum;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();

        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}
