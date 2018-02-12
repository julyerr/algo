package com.julyerr.leetcode.dynamic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int length = triangle.size();
        int[] dp = new int[length];
        int[] dp1 = new int[length];
        dp1[0] = dp[0] = triangle.get(0).get(0);
        int min = dp[0];
        for (int i = 0; i < length - 1; i++) {
            List<Integer> list = triangle.get(i + 1);
            int len = list.size();
            for (int j = 0; j < len; j++) {
                int value = list.get(j);
                if (j != 0 && j != len - 1) {
                    dp[j] = Math.min(dp1[j], dp1[j - 1]) + value;
                } else if (j == 0) {
                    dp[j] = dp1[j] + value;
                    min = dp[j];
                } else {
                    dp[j] = dp1[j - 1] + value;
                }
                if (min > dp[j]) {
                    min = dp[j];
                }
            }
//            notes for the new array allocated , rather than refObj1 = refObj2
            dp1 = Arrays.copyOf(dp, dp.length);
        }
        return min;
    }

    public static void main(String[] args) {
        Integer[][] nums = new Integer[][]{{-1}, {2, 3}, {1, -1, -3}};
        Triangle triangle = new Triangle();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            list.add(Arrays.asList((Integer[]) nums[i]));
        }
        System.out.println(triangle.minimumTotal(list));
    }
}
