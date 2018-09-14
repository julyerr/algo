package com.julyerr.leetcode.array;

/*
 * 参考实现思路：https://segmentfault.com/a/1190000003817671
 * */
public class Duplicates {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int find = 0;
        while (slow != find) {
            slow = nums[slow];
            find = nums[find];
        }
        return slow;
    }
}
