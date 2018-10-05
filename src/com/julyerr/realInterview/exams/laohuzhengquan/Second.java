package com.julyerr.realInterview.exams.laohuzhengquan;

import java.util.*;

public class Second {
    public int[] minK(int[] nums, int n, int k) {
        if (k >= n) {
            return nums;
        }
        int[] rt = new int[k];
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[i] = nums[i];
        }
//        求出最小的k个
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(nums[i]);
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(tmp[i])) {
                rt[index++] = tmp[i];
            }
        }
        return rt;
    }
}
