package org.example;

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 * Kedan's Algo gives the O(n) time complexity and O(1) space complexity
 * Dynamic programming gives O(n) time and space
 */
public class MaximumSubarray {

    public int maxSumKedanes(int[] nums){
        //Kedane's Algo - It fails in some scenarios.
        int len = nums.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for(int i=0;i<len;i++){
            max_ending_here = max_ending_here + nums[i];
            // Use Math.max to find the maximum
            // of maxSoFar and maxEndingHere
            max_so_far = Math.max(max_so_far, max_ending_here);

            // Use Math.max to reset maxEndingHere
            // to 0 if it becomes negative
            max_ending_here = Math.max(max_ending_here, 0);

        }
        return max_ending_here;
    }

    public int maxSumDynamic(int[] nums){

        //this solves 197 Test cases . It has better test case passing than Kedanes.
        int len = nums.length;
        int[] dynArr = new int[len];
        int max_ending_here = Integer.MIN_VALUE;
        if(len == 0)
            return max_ending_here;
        dynArr[0]=nums[0];
        if(len == 1)
            return Math.max(max_ending_here, dynArr[0]);
        for(int i=1; i<len;i++){
            dynArr[i] = Math.max(nums[i], nums[i]+dynArr[i-1]);
            max_ending_here = Math.max(max_ending_here, dynArr[i]);
        }

        return max_ending_here;
    }
}
