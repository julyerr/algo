package com.julyerr.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input: Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */


/**
 * using dfs to get all the results
 */
public class LetterCombination {
    static final char[][] CHAR_MAP = { {},// 0
            {},// 1
            { 'a', 'b', 'c' },// 2
            { 'd', 'e', 'f' },// 3
            { 'g', 'h', 'i' },// 4
            { 'j', 'k', 'l' },// 5
            { 'm', 'n', 'o' },// 6
            { 'p', 'q', 'r', 's' },// 7
            { 't', 'u', 'v' },// 8
            { 'w', 'x', 'y', 'z' } // 9
    };
    List<String> result;
    char[] stack;
    public List<String> letterCombination(String digits){
        if(digits == null|| digits.length()==0){
            return new ArrayList<String>();
        }
        result = new ArrayList<String>();
        stack = new char[digits.length()];
        dfs(digits.toCharArray(),0);
        return result;
    }
    private void dfs(char[] digits,int p){
        if(p == digits.length){
            result.add(new String(digits));
        }else{
            int num = digits[p]-'0';
            stack[p] = digits[p];
            for (char c :
                    CHAR_MAP[num]) {
                dfs(digits,p+1);
            }
        }
    }
}
