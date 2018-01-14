package com.julyerr.leetcode.dynamic;


/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 */
public class ClimbStairs {
    //递归关系式:f(n) = f(n-1)+f(n-2)
    public int climbStairs(int n){
        if(n < 2){
            return 1;
        }
        int[] steps = new int[n+1];
        steps[0] = 0;
        steps[1] = 1;
        for (int i = 2; i <= n; i++) {
            steps[i] = steps[i-2] +steps[i-1];
        }
        return steps[n];
    }

    //整个过程只是使用到三个变量，使用三个变量进行优化
    public int climbStairs2(int n){
        int step0,step1,step2=0;
        step0 = 0;
        step1 = 1;
        if(n <2){
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            step2 = step0+ step1;
            step0 = step1;
            step1 = step2;
        }
        return step2;
    }
}
