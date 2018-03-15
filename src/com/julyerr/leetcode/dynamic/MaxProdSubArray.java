package com.julyerr.leetcode.dynamic;

public class MaxProdSubArray {
    public int maxProduct(int[] nums) {
//      check validation , should not happend here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int curMax = nums[0];
        int curMin = nums[0];
        int max = curMax;
        for (int i = 1; i < nums.length; i++) {
            curMax *= nums[i];
            curMin *= nums[i];
//            大小改变需要交换
            if (curMax < curMin) {
                int t = curMax;
                curMax = curMin;
                curMin = t;
            }
            curMax = Math.max(curMax, nums[i]);
            curMin = Math.min(curMin, nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
