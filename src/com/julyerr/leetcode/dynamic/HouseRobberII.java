package com.julyerr.leetcode.dynamic;

import java.util.Arrays;
import java.util.Collections;

/**
 After robbing those houses on that street, the thief has found himself a new place for his thievery
 so that he will not get too much attention.
 This time, all houses at this place are arranged in a circle.
 That means the first house is the neighbor of the last one.
 Meanwhile, the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 */

//典型的动态规划的问题，每一次计算的结果都是依赖于前面保留下来的值
//    开始没有理解题目意思，关键是起点已经确定了，只是选择的方向可以不同，比较两种选择方式的大小即可
public class HouseRobberII {
    public int robII(int[] nums) {
        int length = nums.length;
        if(length ==0 ){
            return 0;
        }else if(length == 1){
            return nums[0];
        }
        int[] newNums = new int[length];
        for (int i = 0; i < length; i++) {
            newNums[length-1-i] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            System.out.println(newNums[i]);
        }
        return Math.max(this.rob(nums,0,length-1),this.rob(newNums,0,length-1));
    }

    private int rob(int[] nums,int start,int length){
        if(length == 0){
            return 0;
        }else if(length == 1){
            return nums[0];
        }
        int step0,step1,step2;
        step0 =  step2 = 0;
        step1 = nums[0];
        for (int i = start+1; i < length; i++) {
            step2 = Math.max(step1,step0+nums[i]);
            step0 = step1;
            step1 = step2;
        }
        return step2;
    }
    public static void main(String[] args){
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.robII(new int[]{1,1,1}));
    }
}
