package com.julyerr.leetcode.string;

import java.util.ArrayList;

/**
 * Generate Parentheses
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

/**
 * using dfs to overlay the cases
 */
public class GenerateParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> rt = new ArrayList<String>();
        if (n > 0) {
            dfs(rt, "", n, n);
        }
        return rt;
    }

    void dfs(ArrayList<String> rt, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            rt.add(s);
        }
        if (left > 0) {
            dfs(rt, s + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(rt, s + ")", left, right - 1);
        }
    }
}
