package com.julyerr.leetcode.string;

/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and
 * there exists one unique longest palindromic substring.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0;
        int length = end - start;
        for (int i = 0; i < s.length()-length; i++) {
            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)){
                length = longest(s,i,i+1);
            }else{
                length = longest(s,i,i);
            }
            if(start-end<length){
                start = i - (length-1)/2;
                end = i+length/2;
            }else{
                length = start-end+1;
            }
        }
        return s.substring(start,end+1);
    }

    private int longest(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
