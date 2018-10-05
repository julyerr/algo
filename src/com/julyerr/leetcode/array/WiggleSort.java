package com.julyerr.leetcode.array;

/*
 * 更好的方法很难想到，只能通过快排然后调整顺序得到答案
 * */

import java.util.Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        int i = 0;
        if ((nums.length & 1) != 0) {
            i = nums.length >> 1;
        } else {
            i = nums.length / 2 - 1;
        }
        int j = nums.length - 1;
        for (int k = 0; k < nums.length; k++) {
            nums[k] = (k & 1) == 0 ? tmp[i--] : tmp[j--];
        }
    }
}
