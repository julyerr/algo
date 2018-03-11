package com.julyerr.niuke;

import java.util.Scanner;

/*
 * 使用递归的方式超时，使用动态规划
 * */
public class WaysOfMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[]{1, 5, 10, 20, 50, 100};
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(waysOfMoney(nums, n));
        }
    }

//    private static void waysOfMoney(int[] nums, int target, int start) {
//        if (target == 0) {
//            count++;
//            return;
//        }
//        for (int i = start; i < 6; i++) {
//            if (target < nums[i]) {
//                return;
//            }
//            waysOfMoney(nums, target - nums[i], i);
//        }
//    }
//
//    private static long count = 0;

    private static long waysOfMoney(int[] nums, int target) {
        long[] dp = new long[target + 1];
        dp[0] =1;
//        分别就不同的面值进行计算
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
