package com.julyerr.niuke;

import java.util.Scanner;


/*
针对每个山峰，和不与自己相邻的山峰进行比较，其中通过环相连中间山峰的高度不超过两端
* 思路还是容易想到的，但是循环判断会发生超时
*
* 参考大神的思路，使用动态规划：https://www.nowcoder.com/questionTerminal/e1967ae812ea42e7a3ce57ee1f83b686
* 动态规划的方法虽然不会超时，但是数值过大出现内存溢出（通过率90%），还有人使用单项栈实现，很难想到。。。
* */

public class DefendWays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int ret = n;
            boolean[][] dp = new boolean[n][n];
//            针对不相邻的两个山峰进行判断
            for (int gap = 2; gap < n - 1; gap++) {
                for (int i = 0; i < n; i++) {
                    if (!dp[i][(i + gap) % n] && !dp[(i + gap) % n][i]) {
//                        两个山峰之间不能出现比两端高的山峰
                        int k = gap - 1;
                        boolean valid = true;

                        while (k > 0) {
                            if (!(nums[(i + k) % n] <= nums[(i + gap) % n] && nums[(i + k) % n] <= nums[i])) {
                                valid = false;
                                break;
                            }
                            k--;
                        }
                        if (valid) {
                            dp[i][(i + gap) % n] = true;
                            dp[(i + gap) % n][i] = true;
                            ret++;
                        }
                    }
                }
            }

            System.out.println(ret);
        }
    }
}
