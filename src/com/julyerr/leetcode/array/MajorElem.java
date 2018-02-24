package com.julyerr.leetcode.array;

public class MajorElem {
    public int majorityElement(int[] nums) {
//        check validation,should not happen here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int count = 1;
        int m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (m == nums[i]) {
                count++;
            } else if (count > 1) {
                count--;
            } else {
                m = nums[i];
            }
        }
        return m;
    }
}
