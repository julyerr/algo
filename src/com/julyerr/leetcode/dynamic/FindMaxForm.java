package com.julyerr.leetcode.dynamic;

/*
 * 隔了几天没有刷leetcode，感觉有点生疏，还是继续下去，
 * 参考大神解题思路：http://www.cnblogs.com/grandyang/p/6188893.html
 * dp[i][j] 表示拥有i个0和j个1所能组成字符串的最大长度，得到的递归关系式如下
 * dp[i][j] = Math.max(dp[i][j],dp[i-tmpI][j-tmpJ]);
 * */
public class FindMaxForm {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length < 1 || strs[0] == null) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int tmpI = 0, tmpJ = 0;
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') {
                    tmpI++;
                } else {
                    tmpJ++;
                }
            }
//            对每个进行判断
            for (int j = m; j >= tmpI; j--) {
                for (int k = n; k >= tmpJ; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - tmpI][k - tmpJ] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
