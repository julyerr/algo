package com.julyerr.realInterview;

public class NotSameBits {
    public int countBitDiff(int m, int n) {
        int count = 0;
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            if ((m & bit) != (n & bit)) {
                count++;
            }
            bit <<= 1;
        }

        return count;
    }
}
