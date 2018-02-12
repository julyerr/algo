package com.julyerr.leetcode.dynamic;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

//比较有意思，类似的连续最小值，连续最大值先进行运算然后对运算的结果进行判断
public class MaximalProductSubArray {
    public int maxProductSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int positive, negative, max;
        positive = negative = max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            positive *= nums[i];
            negative *= nums[i];
            if (positive < negative) {
                int t = negative;
                negative = positive;
                positive = t;
            }
            positive = Math.max(positive, nums[i]);
            negative = Math.min(negative, nums[i]);
            max = Math.max(max, positive);
        }
        return max;
    }
}
