package com.julyerr.leetcode.array;

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
 * 使用递归，注意保存结果时，应该新建一个ArrayList：result.add(new ArrayList< Integer>(cur))。
 * 否则result会指向一直变化的cur。
 */
public class CombinationSumI {
    public List<List<Integer>> combinationSumI(int target, int[] candidates) {
        //check if the candidates is valid
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(candidates);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        dfs(0, target, result, cur, candidates);
        return result;

    }

    public void dfs(int start, int target, List<List<Integer>> result, List<Integer> cur, int[] candidates) {
        if (target == 0) {
            //add new array to the result
            result.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //if the larger than target
            if (candidates[i] > target) {
                return;
            }
            cur.add(candidates[i]);
            dfs(i, target - candidates[i], result, cur, candidates);
            cur.remove(cur.size() - 1);
        }
    }
}
