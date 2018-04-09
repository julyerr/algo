package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.Scanner;


/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/9ba85699e2824bc29166c92561da77fa?orderByHotValue=1&difficulty=11110&page=1&onlyReference=false
 *
 * 尽可能使两个cpu执行的任务总和相差最小，能够想到转换成容量为sum/2的背包问题也是牛逼了；
 * 设置sum/2大小的背包，然后针对所欲的货物大小更新所能够容纳的最大容量
 * */
public class CPUTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
//                缩小容量空间
                nums[i] = scanner.nextInt() >> 10;
                sum += nums[i];
            }
            int[] dp = new int[sum / 2 + 1];
            for (int i = 0; i < n; i++) {
                for (int j = sum / 2; j >= nums[i]; j--) {
//                    对每件货物，更新能够获取的最大值
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            int tmp = dp[sum / 2];
            System.out.println((tmp > sum - tmp ? tmp : sum - tmp) << 10);
        }
    }
}
