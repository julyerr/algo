package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 参考大神解题思路：https://blog.mythsman.com/2017/03/31/1/
 * 题目给定了限制塔高最大为500000，网上其他的大神提供了使用dp的方法，但是看了半天没有看懂，想算了吧，如果真的遇到这种难度的，只能认栽；
 * 不过强行的暴力求解还是可以想到的，然后针对一些情况进行剪支处理
 * 1.塔高大于500000；
 * 2.较小的塔高加上剩下的所有砖块高度小于另一堆塔高的情况；
 * 3.两个塔高之和加上剩下所有砖块的所有高度之和小于已知最大的高度
 * */
public class TaGao {
    private static final int MAX_HEIGHT = 500000;
    private static int maxHeight = 0;

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] height = new int[n];
            int[] sum = new int[n];
            maxHeight = 0;
            height[0] = scanner.nextInt();
            for (int i = 1; i < n; i++) {
                height[i] = scanner.nextInt();
            }
            Arrays.sort(height);
            sum[0] = height[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + height[i];
            }
            dfs(n - 1, sum, height, 0, 0);
            System.out.println(maxHeight == 0 ? -1 : maxHeight);
        }
    }

    private static void dfs(int n, int[] sum, int[] height, int sum1, int sum2) {
        if (sum1 == sum2) {
            maxHeight = Math.max(maxHeight, sum1);
        }
//        对应三种剪枝策略，大于最大的规定塔高、矮的塔高加上剩下所有砖高度之和小于另一塔高、任意一个塔高加上剩下的砖块之后小于已有相等高度
        if (n < 0 || sum1 > MAX_HEIGHT || sum1 + sum[n] < sum2 || sum1 + sum2 + sum[n] <= 2 * maxHeight) {
            return;
        }
//        将该砖放在A塔还是B塔上或者不放
        dfs(n - 1, sum, height, Math.min(sum1 + height[n], sum2), Math.max(sum1 + height[n], sum2));
        dfs(n - 1, sum, height, Math.min(sum2 + height[n], sum1), Math.max(sum2 + height[n], sum1));
        dfs(n - 1, sum, height, sum1, sum2);
    }
}
