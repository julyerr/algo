package com.julyerr.leetcode.string;

/*
 * 参考解题思路：http://www.cnblogs.com/grandyang/p/5852352.html
 * 子串中不能包含出现次数小于k的字符,然后递归比较求解出最大值
 * */


public class LongestSubstringK {
    public int longestSubstring(String s, int k) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        boolean ok = true;
        int ret = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c - 'a'] < k) {
                ret = Math.max(ret, longestSubstring(s.substring(start, i), k));
                ok = false;
                start = i + 1;
            }
        }
        return ok ? s.length() : Math.max(ret, longestSubstring(s.substring(start, s.length()), k));
    }

    public static void main(String[] args) {
        LongestSubstringK longestSubstringK = new LongestSubstringK();
        String s = "ababbc";
//        System.out.println("substring,"+s.substring(0,s.length()));
        int k = 2;
        System.out.println(longestSubstringK.longestSubstring(s, k));
    }
}
