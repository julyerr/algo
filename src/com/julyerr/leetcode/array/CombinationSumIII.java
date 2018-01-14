package com.julyerr.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.

 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]
 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */

/**
 * similar to CombinationSumII , without candidates
 * for efficiency , using level instead of array.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSumIII(int k,int n){
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        if(k <1 || n<1){
            return rt;
        }
        List<Integer> cur = new ArrayList<Integer>();
        dfs(rt,cur,0,n,k,1);
        return rt;
    }
    private void dfs(List<List<Integer>> rt,List<Integer> cur,int sum,int n,int k,int level){
        if(sum == n &&  k==0){
            rt.add(new ArrayList<Integer>(cur));
            return;
        }else if(sum >= n || k <= 0){
            return;
        }
        for (int i = level; i <=9 ; i++) {
            cur.add(i);
            dfs(rt,cur,sum+i,n,k-1,i+1);
            cur.remove(cur.size()-1);
        }
    }
}
