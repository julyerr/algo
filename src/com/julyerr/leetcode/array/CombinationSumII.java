package com.julyerr.leetcode.array;

/**
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]


 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用递归，注意保存结果时，应该新建一个ArrayList：result.offer(new ArrayList< Integer>(cur))。
 * 否则result会指向一直变化的cur。
 *
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSumII(int target, int[] candidates) {
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
            //offer new array to the result
            result.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //if the larger than target
            if (candidates[i] > target) {
                return;
            }
            cur.add(candidates[i]);
            dfs(i+1, target-candidates[i], result, cur, candidates);
            cur.remove(cur.size() - 1);
        }
    }
}
