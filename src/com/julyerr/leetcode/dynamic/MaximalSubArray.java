package com.julyerr.leetcode.dynamic;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

//这道题目开始自己写考虑不周全，看懂之后这种方法真的很妙
//文章：http://blog.csdn.net/yano_nankai/article/details/49965833

//    比较典型的dp编程题目就是：多少种不同的方案，求最大值、求最小值
//    关注当下最有解，针对这个最优解进行比较
public class MaximalSubArray {
    public int maximalSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int curSum = nums[0];
        int maxSum = nums[0];
        int begin,end;
        begin = end =0;
        for (int i = 1; i < nums.length; i++) {
            curSum += nums[i];
            if(nums[i] > curSum){
                begin = end = i;
                curSum = nums[i];
            }
            if(curSum > maxSum){
                maxSum = curSum;
                end = i;
            }
        }
        System.out.println("begin:"+begin+" end:"+end);
        return maxSum;
    }
    public static void main(String[] args){
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{8,-19,5,-4,20};
        MaximalSubArray maximalSubArray = new MaximalSubArray();
        System.out.println(maximalSubArray.maximalSubArray(nums));
    }
}
