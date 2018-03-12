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
    public int strStr(String haystack, String needle) {
//        有效性判断
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        int lenA = haystack.length();
        int lenB = needle.length();
        if (lenA == 0) {
            return 0;
        }
        for (int i = 0; i < lenA; i++) {
            int count = 0;
//            针对每个字符循环判断
            for (int j = 0; j < lenB; j++) {
//                如果超过haystack的范围，return -1
                if (i + count >= lenA) {
                    return -1;
                }
                if (haystack.charAt(i + count) != needle.charAt(j)) {
                    break;
                }
                count++;
            }
            if (count == lenB) {
                return i;
            }
        }
        return -1;
    }
}
