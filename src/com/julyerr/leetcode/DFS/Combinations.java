package com.julyerr.leetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    //    存储的次数
    static int times;
    //    全局数组
    static Integer[] nums;
    static Integer[] cur;
    List<List<Integer>> rt;

    public List<List<Integer>> combine(int n, int k) {
        rt = new ArrayList<>();
//        check validation
        if (n < 1 || k < 1) {
            return rt;
        }
//        赋新值
        nums = new Integer[n];
        cur = new Integer[k];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        times = k;
        dfs(0);
        return rt;
    }

    private void dfs(int start) {
        if (start == times) {
            rt.add(new ArrayList<>(Arrays.asList(cur)));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
//            比最后一个元素大的值
            if (start > 0 && nums[i] <= cur[start - 1]) {
                continue;
            }

            cur[start] = nums[i];
            dfs(start + 1);
        }
    }
}
