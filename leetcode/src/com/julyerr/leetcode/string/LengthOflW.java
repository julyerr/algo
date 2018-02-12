package com.julyerr.leetcode.string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */

/**
 *
 * just scan the string from the last to forward and skip the white space is ok.
 */
public class LengthOflW {
    public int lengOfLastWord(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int i = s.length()-1;
        int len = 0;
        while(i >= 0 && s.charAt(i) ==' '){
            i--;
        }
        while(i>=0 && s.charAt(i)!=' '){
            i--;
            len++;
        }
        return len;
    }
}
