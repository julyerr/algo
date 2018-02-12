package com.julyerr.leetcode.string;

/**
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */


/**
 * 就是字符串的暴力求解的方式
 */
public class Strstr {
    public int strStr(String hayStack, String needle) {
        if (hayStack == null || needle == null || needle.length() > hayStack.length()) {
            return -1;
        }
        for (int i = 0; i < hayStack.length(); i++) {
            if (i + needle.length() > hayStack.length()) {
                return -1;
            }
            int m = i;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) == hayStack.charAt(m)) {
                    if (j == needle.length() - 1) {
                        return i;
                    }
                    m++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}
