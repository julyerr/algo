package com.julyerr.leetcode.bitmap;

public class BitwiseAnd {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
//            统计移动的次数
            count++;
        }
        return m << count;
    }
}
