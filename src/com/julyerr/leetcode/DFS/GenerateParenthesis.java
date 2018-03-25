package com.julyerr.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

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
    public List<String> generateParenthesis(int n) {
        List<String> rt = new ArrayList<>();
        if (n < 1) {
            return rt;
        }
        dfs(rt, "", n, n);
        return rt;
    }

    private void dfs(List<String> rt, String cur, int left, int right) {
//        保证left优先出现
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            rt.add(cur);
            return;
        }
//        先生成（
        if (left > 0) {
            dfs(rt, cur + '(', left - 1, right);
        }

//        后生成）
        if (right > 0) {
            dfs(rt, cur + ')', left, right);
        }
    }
}
