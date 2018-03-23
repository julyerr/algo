package com.julyerr.leetcode.bitmap;

public class SingleNumberI {
    public int singleNumber(int[] nums) {
        if(nums==null||nums.length ==0){
            return -1;
        }
        int n = 0;
//        每一位^操作
        for (int i :
                nums) {
            n ^= i;
        }
        return n;
    }
}
