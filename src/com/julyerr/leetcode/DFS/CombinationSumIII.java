package com.julyerr.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that offer up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Ensure that numbers within the set are sorted in ascending order.
 * <p>
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * <p>
 * Output:
 * <p>
 * [[1,2,4]]
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * <p>
 * Output:
 * <p>
 * [[1,2,6], [1,3,5], [2,3,4]]
 */

/**
 * similar to CombinationSumII , without candidates
 * for efficiency , using level instead of array.
 */
public class CombinationSumIII {
    static List<List<Integer>> rt;

    public List<List<Integer>> combinationSum3(int k, int n) {
        rt = new ArrayList<>();
//        check validation
        if (k < 1 || n < 1) {
            return rt;
        }
        dfs(0, n, k, new ArrayList<>());
        return rt;
    }

    private static void dfs(int start, int n, int k, List<Integer> cur) {
        if (k == 0 && n == 0) {
            rt.add(new ArrayList<>(cur));
            return;
        } else if (n <= 0 || k <= 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > n) {
                return;
            }
            cur.add(i);
            dfs(i + 1, n - i, k - 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
