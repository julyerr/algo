package com.julyerr.leetcode.DFS;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用递归，注意保存结果时，应该新建一个ArrayList：result.offer(new ArrayList< Integer>(cur))。
 * 否则result会指向一直变化的cur。
 */
public class CombinationSumI {
    static List<List<Integer>> rt;
    static int[] candidate;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        rt = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return rt;
        }
//        sort the arrays
        Arrays.sort(candidates);
        candidate = candidates;
        dfs(0, target, new ArrayList<>());
        return rt;
    }

    private static void dfs(int start, int target, List<Integer> cur) {
        if (target == 0) {
            rt.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidate.length; i++) {
//            large than remaining elems
            if (target < candidate[i]) {
                return;
            }
            cur.add(candidate[i]);
            dfs(i, target - candidate[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}
