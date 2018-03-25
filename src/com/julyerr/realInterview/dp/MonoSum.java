package com.julyerr.realInterview.dp;

import java.util.Scanner;

public class MonoSum {
    //    可以使用动态规划，将局部最优解保存下来。但是这道题可以直接返回结果，不设数组反而节省空间
    public int calcMonoSum(int[] A, int n) {
        if (n < 2) {
            return -1;
        }
        int ret = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] >= A[j]) {
                    ret += A[j];
                }
            }
        }
        return ret;
    }
}
