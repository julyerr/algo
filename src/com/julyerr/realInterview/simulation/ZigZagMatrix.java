package com.julyerr.realInterview.simulation;

public class ZigZagMatrix {
    public int[] printMatrix(int[][] mat, int n, int m) {
        int total = n * m;
        int[] nums = new int[total];

        boolean flag = true;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (flag) {
                for (int j = 0; j < m; j++) {
                    nums[index++] = mat[i][j];
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    nums[index++] = mat[i][j];
                }
            }
            flag = !flag;
        }

        return nums;
    }
    public String rotateString(String A, int n, int p) {
        return A.substring(p+1)+A.substring(0,p+1);
    }
}
