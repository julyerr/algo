package com.julyerr.leetcode.dynamic;

/*
* 主要参考思路：
* https://blog.csdn.net/chunkitlau/article/details/53377402
* https://blog.csdn.net/Double2hao/article/details/51727420
* */

import java.util.Arrays;
import java.util.Scanner;

public class MaxSubMatrix {
    public int maxSubMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp, 0);
            for (int j = i; j < m; j++) {
                int tmp = 0;
                for (int k = 0; k < n; k++) {
                    dp[k] += matrix[j][k];
                    tmp = Math.max(tmp + dp[k], dp[k]);
                    max = Math.max(max, tmp);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println(new MaxSubMatrix().maxSubMatrix(matrix));
    }
}
