package com.julyerr.leetcode.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 参考资料：https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51644993
* */
public class PermutationII {
    private List<List<Integer>> rt = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return rt;
        }
        dfs(0, nums);
        return rt;
    }

    private void dfs(int start, int[] nums) {
        int len = nums.length;
        if (start == len - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            rt.add(list);
            return;
        }
        //判断是否进行了重复添加的情况
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < len; i++) {
            if (set.add(nums[i])) {
                swap(nums, start, i);
                dfs(start + 1, nums);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
