package com.julyerr.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum {
    public int[] twoSum(int[] nums,int target){
        //check if the nums is valid
        if(null==nums||nums.length<=1){
            return new int[2];
        }

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            map.put(target-nums[i],i);
        }

        for(int i =0;i<nums.length;i++){
            Integer v = map.get(nums[i]);
            //v exits and v cannot be itself
            if(null!=v&&v!=i){
                return new int[]{v+1,i+1};
            }
        }

        return null;
    }
}
