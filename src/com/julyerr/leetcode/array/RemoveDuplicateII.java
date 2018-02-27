package com.julyerr.leetcode.array;

public class RemoveDuplicateII {
    public int removeDuplicates(int[] nums) {
//        check validation
        if(nums == null){
            return -1;
        }else if(nums.length < 3) {
            return nums.length;
        }
        int index = 0;
        for (int i = 2; i < nums.length; i++) {
//            是否超过2个元素相等
            if (!(nums[i] == nums[index] && nums[i - 1] == nums[index])) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}