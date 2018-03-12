package com.julyerr.leetcode.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LenOfCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs.length;
//        如果只存在一个字符串直接返回
        if (length == 1) {
            return strs[0];
        }
        int ret = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean valid = true;
//            针对字符串组的当下字符进行判断
            for (int j = 1; j < length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                break;
            }
            ret++;
        }
        return strs[0].substring(0, ret);
    }
}
