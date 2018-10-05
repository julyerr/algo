package com.julyerr.leetcode.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
* 不行就暴力，暴力是一种相对来说比较好的方法
* */
public class RandomIndex {
    private int[] nums;
    private Random random;

    public RandomIndex(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        List<Integer> tmp = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                tmp.add(i);
            }
        }
        return tmp.get(random.nextInt(tmp.size()));
    }
}
