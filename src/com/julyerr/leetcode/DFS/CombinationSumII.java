package com.julyerr.leetcode.DFS;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * Each number in C may only be used once in the combination.
 * <p>
 * Note:
 * <p>
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */

import java.util.*;

/**
 * 使用递归，注意保存结果时，应该新建一个ArrayList：result.offer(new ArrayList< Integer>(cur))。
 * 否则result会指向一直变化的cur。
 */
public class CombinationSumII {
    static Set<List<Integer>> rt;
    static int[] candidate;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        rt = new HashSet<>();
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>(rt);
        }
//        sort the arrays
        Arrays.sort(candidates);
        candidate = candidates;
        dfs(0, target, new ArrayList<>());
        return new ArrayList<>(rt);
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
            dfs(i + 1, target - candidate[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}
