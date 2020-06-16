package com.janguo.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Solution02 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,8,11,7,10};
        int targrt = 18;
        // System.out.println(Arrays.toString(new Solution02().governmentViolenceMethod(nums, targrt)));
        // System.out.println(Arrays.toString(new Solution02().governmentHashMethod(nums, targrt)));
        System.out.println(Arrays.toString(new Solution02().governmentOneHashMethod(nums, targrt)));



    }


    int[] method01(int[] nums,int target){
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                int k = nums[i] + nums[j];
                if (i==target&&i!=j){
                    result[0]= i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
    int[] governmentViolenceMethod(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == target - nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    int[] governmentHashMethod(int[] nums ,int target){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int adjective = target - nums[i];
            if (hashMap.containsKey(adjective)&&hashMap.get(adjective)!=i){
                return new int[]{i,hashMap.get(adjective)};
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    int[] governmentOneHashMethod(int[] nums ,int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int adjective = target - nums[i];
            if (hashMap.containsKey(adjective))
            {
                return new int[]{hashMap.get(adjective),i};
            }
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
