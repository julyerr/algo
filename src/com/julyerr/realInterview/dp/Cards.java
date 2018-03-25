package com.julyerr.realInterview.dp;

/*
 * 此题真的是做不来，真的是大神才能使用动态规划：https://www.nowcoder.com/questionTerminal/7036f62c64ba4104a28deee98a6f53f6
 * */
public class Cards {
    public int cardGame(int[] A, int n) {
//        f[i][j]在i-j张牌中，先选择的人获取到的分数
//        s[i][j]在i-j张牌中，后选择的人获取到的分数
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = A[i];
            for (int j = i - 1; j >= 0; j--) {
//                拿第一张牌或者最后一张牌
                f[j][i] = Math.max(A[j] + s[j + 1][i], A[i] + s[j][i - 1]);
                s[j][i] = Math.min(f[j + 1][i], f[j][i - 1]);
            }
        }
        return Math.max(f[0][n - 1], s[0][n - 1]);
    }

    public static void main(String[] args) {
        Cards cards = new Cards();
        int[] nums = new int[]{1, 2, 100, 4};
        System.out.println(cards.cardGame(nums, nums.length));
    }
}
