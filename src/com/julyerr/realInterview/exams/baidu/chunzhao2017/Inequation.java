package com.julyerr.realInterview.exams.baidu.chunzhao2017;

import java.util.Scanner;

/*
 *
 * 参考大神的解题思路：https://www.nowcoder.com/test/question/done?tid=14939450&qid=95828#summary
 * 使用动态规划，真的难想，话说只有动态规划才适合此题
 *
 * dp[i][j] 表示i个数字有j个'<',可以进行如下分析
 * 1.直接添加到最开始，此时多添加一个>,种类数+dp[i-1][j];
 * 2.直接添加到最后面，此时多添加一个<,种类数+dp[i-1][j-1];
 * 3.添加到中间任意一个<,例如1<2，变成1<3>2,多添加了一个>，种类数+dp[i-1][j]*j;
 * 4.添加到中间任意一个>，例如2>1,变成2<3>1,多添加了一个<,种类数+dp[i-1][j-1]*(i-j-1)
 * 整理可得到：dp[i][j] = dp[i-1][j]*(j+1)+dp[i-1][j-1]*(i-j)
 *
 * */
public class Inequation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] dp = new int[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = 1;
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = (dp[i - 1][j] * (j + 1) + dp[i - 1][j - 1] * (i - j)) % 2017;
                }
            }
            System.out.println(dp[n][k]);
        }
    }
}
