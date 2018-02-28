package com.julyerr.leetcode.searchSort;

public class SearchInsertion {
    public int searchInsert(int[] nums, int target) {
//        check validation
        if(nums == null || nums.length ==0){
            return 0;
        }
        int i = 0;
        for (i = nums.length-1; i >= 0 ; i--) {
            if(target > nums[i]){
                break;
            }
        }
        return i+1;
    }
}
