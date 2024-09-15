package org.example;

public class FindMaxAverageSubarray {
    /**
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     * Example 2:
     *
     * Input: nums = [5], k = 1
     * Output: 5.00000
     */

    /**
     *
     * @param nums
     * @param k
     * @return double value holding max average.
     *
     * SLIDING WINDOW METHOD - O(n)
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, start = 0;
        double max = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i >= k - 1) {
                double avg = (double) sum / k;
                max = Math.max(max, avg);
                sum -= nums[start];
                start++;
            }
        }
        return max;
    }
}
