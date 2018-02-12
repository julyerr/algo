package com.julyerr.leetcode.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LenOfCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String string = strs[0];
        if (strs.length == 1) {
            return string;
        }
        for (int i = 0; i < string.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (!(i < strs[j].length() && string.charAt(i) == strs[j].charAt(j))) {
                    return string.substring(0, i);
                }
            }
        }
        return string;
    }
}
