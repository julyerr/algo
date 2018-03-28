package com.julyerr.leetcode.array;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.

 Note:

 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 */

/**
 * similar to three sums , just offer a more loop
 *
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums,int target){
        if(nums == null || nums.length <4){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int a = 0; a < nums.length - 3; a++) {
            //just offer one0327 more loop
            int target3Sum = target - nums[a];
            for (int b = 0; b < nums.length - 2; b++) {
                int c = b+1,d = nums.length-1;
                while(c<d){
                    int sum = nums[a]+nums[b]+nums[c]+nums[d];
                    if(sum == target3Sum){
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[a]);
                        tmp.add(nums[b]);
                        tmp.add(nums[c]);
                        tmp.add(nums[d]);
                        while(++c<d&& nums[c-1]==nums[c]);
                        while(--d>c&& nums[d]==nums[d+1]);
                    }else if(sum<target3Sum){
                        c++;
                    }else{
                        d--;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }
}
