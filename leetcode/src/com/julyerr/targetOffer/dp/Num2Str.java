package com.julyerr.targetOffer.dp;

/**
 * 给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”...25翻译成“z”。
 * 一个数字有多种翻译可能，例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */

/**
 * 简单的dp，只是需要先将number装换成str
 */
public class Num2Str {
    public int ways(int number) {
        if (number <= 0) {
            return 0;
        }
//        通过字符串变换
        String str = new String(Integer.toString(number));
        int length = str.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= length; i++) {
            dp[i] = dp[i - 1];
            int tmp = (str.charAt(i - 2) - '0') * 10 + str.charAt(i - 1) - '0';
            if (tmp <= 25) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        Num2Str num2Str = new Num2Str();
        System.out.println(num2Str.ways(-10));
        System.out.println(num2Str.ways(1234));
        System.out.println(num2Str.ways(12258));
    }
}