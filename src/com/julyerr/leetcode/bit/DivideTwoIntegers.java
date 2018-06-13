package com.julyerr.leetcode.bit;

/*
 * 参考思路：http://www.cnblogs.com/TenosDoIt/p/3795342.html
 * */

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean minus = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;
        long divid = Math.abs((long) dividend);
        long divis = Math.abs((long) divisor);
//        边界条件的判断
        if (-divid == Integer.MIN_VALUE && divis == 1) {
            return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        int rt = 0;
        while (divid >= divis) {
            int i = 0;
            long tmp = divis;
            for (i = 1; tmp <= divid; i++) {
                tmp <<= 1;
            }
            rt += 1 << (i - 2);
            divid -= (tmp >> 1);
        }
        return minus ? -rt : rt;
    }

    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(-2147483648, -1));
    }
}
