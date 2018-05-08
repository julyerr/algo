package com.julyerr.leetcode.dynamic;

import java.util.HashSet;
import java.util.Set;

/*
 * 此题还是比较的tricky，参考资料：http://www.cnblogs.com/grandyang/p/6143071.html
 * 转换成每个字符结尾的最长连续子串
 * */
public class WrappedSubstring {
    public int findSubstringInWraproundString(String p) {
        if(p==null||p.length()<1){
            return 0;
        }
        int[] dp = new int[26];
        dp[p.charAt(0) - 'a']++;
        int len = 1;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == p.charAt(i - 1) + 1 || p.charAt(i - 1) - p.charAt(i) == 25) {
                len++;
            } else {
                len = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], len);
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
