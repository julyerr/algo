package com.julyerr.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/*
* 参考资料：https://www.jianshu.com/p/db90675cb82b
* */
public class Permutation {
    private List<List<Integer>> rt = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
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
            for (int i = 0; i < len; i++) {
                list.add(nums[i]);
            }
            rt.add(list);
            return;
        }
        for (int i = start; i < len; i++) {
            swap(nums, i, start);
            dfs(start + 1, nums);
            swap(nums, i, start);
        }
    }

//    进行数据的交换
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
