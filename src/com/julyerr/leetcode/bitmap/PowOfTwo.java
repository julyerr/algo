package com.julyerr.leetcode.bitmap;

public class PowOfTwo {
    public boolean isPowerOfTwo(int n) {
//        所有的非正数均不是2的次数幂
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
