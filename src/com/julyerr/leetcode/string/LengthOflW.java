package com.julyerr.leetcode.string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * For example,
 * Given s = "Hello World",
 * return 5.
 */

/**
 * just scan the string from the last to forward and skip the white space is ok.
 */
public class LengthOflW {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int ret = 0;
        for (int i = length - 1; i >= 0; i--) {
//            如果是空格，跳过或者是结束循环
            if (s.charAt(i) == ' ') {
                if (ret == 0) {
                    continue;
                } else {
                    break;
                }
            }
            ret++;
        }
        return ret;
    }
}
