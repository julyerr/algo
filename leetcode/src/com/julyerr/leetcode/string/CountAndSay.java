package com.julyerr.leetcode.string;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 *
 */

/**
 * using for loop
 */
public class CountAndSay {
    public String countAndSay(int n){
        String init = "1";
        for (int i = 0; i < n; i++) {
            init = countAndSay(init);
        }
        return init;
    }

    private String countAndSay(String str){
        char[] strs = str.toCharArray();
        int p = 1;
        int count = 1;
        int last = strs[0];
        String result = "";
        for (; p < strs.length; p++) {
            if(strs[p] == last){
                count++;
            }else{
                result += ""+count+last;
                count = 1;
                last = strs[p];
            }
        }
        result += ""+count+last;
        return result;
    }
}
