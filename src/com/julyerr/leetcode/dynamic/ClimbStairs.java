package com.julyerr.leetcode.dynamic;


/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if(n<2){
            return n;
        }
        int step0 = 1;
        int step1 = 1;
        int step2 =0;
//        三个变量，循环计算结果
        for (int i = 2; i <= n; i++) {
            step2 = step0+step1;
            step0 = step1;
            step1 = step2;
        }
        return step2;
    }
}
