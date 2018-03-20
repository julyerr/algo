package com.julyerr.leetcode.bitmap;

public class NumberOfOneBit {
    public int hammingWeight(int n) {
        int bit = 1;
        int count = 0;
//        0-31的位置针对每一位进行与操作
        for (int i = 0; i < 32; i++) {
            if ((n & bit) != 0) {
                count++;
            }
            bit <<= 1;
        }

        return count;
    }
}
