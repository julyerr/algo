package com.julyerr.leetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    static List<List<Integer>> rt;
    static int times;
    static Integer[] cur;

    public List<List<Integer>> subsets(int[] nums) {
        rt = new ArrayList<>();
        //        check validation
        if (nums == null || nums.length == 0) {
            return rt;
        }
//        sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
//            针对不同的长度进行更新
            times = i;
            cur = new Integer[i];
            dfs(nums, 0);
        }
        return rt;
    }

    private void dfs(int[] nums, int start) {
        if (start == times) {
            rt.add(new ArrayList<>(Arrays.asList(cur)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (start > 0 && nums[i] <= cur[start - 1]) {
                continue;
            }
            cur[start] = nums[i];
            dfs(nums, start + 1);
        }
    }
}
