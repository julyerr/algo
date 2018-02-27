package com.julyerr.leetcode.array;

public class RemoveDuplicateI {
    public int removeDuplicates(int[] nums) {
//        check validation
        if (nums == null) {
            return -1;
        } else if (nums.length < 2) {
            return nums.length;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
