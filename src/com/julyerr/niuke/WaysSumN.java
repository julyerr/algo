package com.julyerr.niuke;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 使用递归的方式，会超时
 * 参考大神的思路，使用动态规划
 * https://www.nowcoder.com/questionTerminal/7f24eb7266ce4b0792ce8721d6259800
 * */
public class WaysSumN {
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            int sum = scanner.nextInt();
//            int[] nums = new int[n];
//            for (int i = 0; i < n; i++) {
//                nums[i] = scanner.nextInt();
//            }
//            Arrays.searchSort(nums);
//            dfs(nums, sum, 0);
//            System.out.println(ways);
//        }
//    }
//
//    static int ways = 0;
//
//    private static void dfs(int[] nums, int target, int start) {
//        if (target == 0) {
//            ways++;
//        }
//        for (int i = start; i < nums.length; i++) {
////            元素值已经足够大
//            if (nums[i] > target) {
//                return;
//            }
//            dfs(nums, target-nums[i], i+1);
//        }
//    }

    //    背包问题
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] nums = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                nums[i] = scanner.nextInt();
            }
            long[][] dp = new long[1000][1000];
//            前i个数，和为0，只能不取一种方式
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }
//            前0个元素，和为i，没有这种方式
            for (int i = 1; i < sum; i++) {
                dp[0][i] = 0;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (nums[i] <= j) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[n][sum]);
        }
    }
}
