package com.julyerr.leetcode.dynamic;


/*
 * 更偏向于找规律的题目
 * n>4，拆分为*3,n-=3;
 * n<=4可以直接返回
 * */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int rt = 1;
        while (true) {
            if (n > 4) {
                rt *= 3;
                n -= 3;
            } else {
                rt *= n;
                break;
            }
        }
        return rt;
    }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(10));
    }
}
