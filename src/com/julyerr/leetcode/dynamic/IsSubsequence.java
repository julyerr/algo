package com.julyerr.leetcode.dynamic;

/*
 * 这道题目还有更为简单的方法，因为其中s是连续的，t才是未连续的，可以设置两个游标简化操作
 * */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int k1 = 0, k2 = 0;
        while (k1 < s.length() && k2 < t.length()) {
            if (s.charAt(k1) == t.charAt(k2)) {
                k1++;
            }
            k2++;
        }
        return k1 == s.length();
    }
}
