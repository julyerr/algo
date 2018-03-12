package com.julyerr.leetcode.string;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 */
public class DecodeWay {
//    public int decodeWays(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        char[] c = s.toCharArray();
//        int[] steps = new int[Math.max(s.length()+1,3)];
//        int n = steps.length;
//        steps[0] = 1;
//        if(c[0] !='0') {
//            steps[1] = 1;
//        }
//        for (int i = 2; i <= n; i++) {
//            steps[i] = 0;
//            if(steps[i-1] !='0'){
//                steps[i] += steps[i-1];
//            }
//            if(steps[i-2] !='0'){
//                if((10*(steps[i-2]-'0')+steps[i-1]-'0') <= 26){
//                    steps[i] += steps[i-2];
//                }
//            }
//        }
//        return steps[n];
//    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length + 1];
//        初始化参数
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= length; i++) {
            char c = s.charAt(i-1);
//            前面两个字符的数字表示大小
            int tmp = (s.charAt(i - 2) - '0') * 10 + c - '0';
            if (c == '0') {
//                不在1-26之间
                if (tmp<=0 || tmp > 26) {
                    return 0;
                }
                dp[i] = dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
//                在10-26之间
                if (tmp <= 26 && tmp >10) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[length];
    }
}
