package com.julyerr.realInterview.str;

public class LongestPalindrome {
    //    非常经典的题目，针对每个字符串判断回文长度即可
    public int getLongestPalindrome(String A, int n) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        int length = 1;
        for (int i = 1; i < A.length() - length / 2; i++) {
            length = Math.max(length, Math.max(lenPalindrome(A, i, i), lenPalindrome(A, i - 1, i)));
        }
        return length;
    }

    private int lenPalindrome(String A, int left, int right) {
        while (left >= 0 && right < A.length() && A.charAt(left) == A.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
