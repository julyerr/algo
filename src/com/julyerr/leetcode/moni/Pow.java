package com.julyerr.leetcode.moni;

public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean minus = false;
        if (n < 0) {
            minus = true;
            n = -n;
        }
        double rt = 1;
        int bit = 1;
        double tmp = x * x;
        if ((n & 1) != 0) {
            rt = x;
        }
        for (int i = 1; i <= 31; i++) {
            if ((n & (1 << i)) != 0) {
                rt *= tmp;
            }
//            相当于指数型增长
            tmp *= tmp;
        }
        return minus ? 1 / rt : rt;
    }

    public static void main(String[] args){
        Pow pow = new Pow();
        System.out.println(pow.myPow(2,-10));
    }
}
