package com.julyerr.leetcode.string;

/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and
 * there exists one0327 unique longest palindromic substring.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s==null||s.length() < 2){
            return s;
        }
        int start = 0,len = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
//            不可能出现更长的回文
            if(i+len/2 >= length){
                break;
            }
//            当前字符的回文长度计算
            int len1 = lenPalindromeOfThisChar(s,i,i);
            int len2 = lenPalindromeOfThisChar(s,i,i+1);
            int tmp = Math.max(len1,len2);
            if(len < tmp){
                len = tmp;
                start = i - (len-1) / 2;
            }
        }
        return s.substring(start,start+len);
    }

    private int lenPalindromeOfThisChar(String s,int left,int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
