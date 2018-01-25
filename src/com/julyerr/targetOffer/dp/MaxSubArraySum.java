package com.julyerr.targetOffer.dp;

/**
 * 输入一个整形数组，数组里有正数也有负数。数组中一个或连续多个整数组成一个子数组。求所有子数组的和的最大值，要求时间复杂度为o(n)。
 */
public class MaxSubArraySum {
    public int FindGreatestSumOfSubArray(int[] array) {
//        should not happend here
        if(array == null || array.length == 0){
            return 0;
        }
        int max = array[0];
        int cur = array[0];
        for (int i = 1; i < array.length; i++) {
            cur = Math.max(cur+array[i],array[i]);
            max = Math.max(max,cur);
        }
        return max;
    }
    public static void main(String[] args){
        MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
        int[] nums = new int[]{6,-3,-2,7,-15,1,2,2};
        System.out.println(maxSubArraySum.FindGreatestSumOfSubArray(nums));
    }
}
