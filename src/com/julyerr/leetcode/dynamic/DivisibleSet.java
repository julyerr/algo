package com.julyerr.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 参考大神的解题思路：https://blog.csdn.net/qq508618087/article/details/51767785
 * */
public class DivisibleSet {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> rt = new ArrayList<>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        //        记录路径
        int[] path = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            path[i] = i;
        }
        int startIndex = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
//                    更改大小
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        path[i] = j;
                    }
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                startIndex = i;
            }
        }
        while (startIndex != path[startIndex]) {
            rt.add(nums[startIndex]);
            startIndex = path[startIndex];
        }
        rt.add(nums[startIndex]);
        Collections.reverse(rt);
        return rt;
    }

    public static void main(String[] args) {
        DivisibleSet divisibleSet = new DivisibleSet();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(divisibleSet.largestDivisibleSubset(nums).toString());
    }
}
