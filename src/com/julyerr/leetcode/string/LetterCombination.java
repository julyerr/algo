package com.julyerr.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p>
 * <p>
 * <p>
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */


/**
 * using dfs to get all the results
 */
public class LetterCombination {
    static final char[][] CHAR_MAP = {{' '},// 0
            {},// 1
            {'a', 'b', 'c'},// 2
            {'d', 'e', 'f'},// 3
            {'g', 'h', 'i'},// 4
            {'j', 'k', 'l'},// 5
            {'m', 'n', 'o'},// 6
            {'p', 'q', 'r', 's'},// 7
            {'t', 'u', 'v'},// 8
            {'w', 'x', 'y', 'z'} // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> rt = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return rt;
        }
        dfs(rt, "", 0, digits);
        return rt;
    }

    private void dfs(List<String> rt, String cur, int level, String digits) {
        int length = digits.length();
//        递归到结束位置，添加字符串
        if (level >= length) {
            rt.add(cur);
            return;
        }
        int offset = digits.charAt(level) - '0';
//        当前各种情况判断
        for (int i = 0; i < CHAR_MAP[offset].length; i++) {
            dfs(rt, cur + CHAR_MAP[offset][i], level + 1, digits);
        }
    }
}
