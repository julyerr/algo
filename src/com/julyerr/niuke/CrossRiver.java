package com.julyerr.niuke;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 参考大神的解题思路，https://www.nowcoder.com/questionTerminal/74acf832651e45bd9e059c59bc6e1cbf
 * 使用动态递归，然后注意边缘条件
 * */
public class CrossRiver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(crossRiver(nums));
        }
    }

    private static int crossRiver(int[] nums) {
        int n = nums.length;
        int[] dp = new int[10000];
        dp[0] = 1;
        Arrays.fill(dp, 10000);
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        if (dp[n] == 10000) {
            return -1;
        }
        return dp[n] - 1;
    }
}
