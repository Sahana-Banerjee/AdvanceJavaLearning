package org.example;

import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 */
public class TwoSumLeetEasy {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int len = nums.length;
            for(int i=0;i<len;i++){
                int compliment = target-nums[i];
                if(map.containsKey(compliment))
                    return new int[]{map.get(compliment), i};
                map.put(nums[i],i);
            }
            return new int[]{};
        }

    public static void main(String[] args) {
//        int[] result = twoSum();
    }
}
