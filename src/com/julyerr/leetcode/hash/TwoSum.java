package com.julyerr.leetcode.hash;


import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one0327 solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

/*
 * 和为定值，只有一个解;
 * 使用hash，map.put(sum-num[i],i)，然后判断是否存在num[i]的key
 * 存在即可返回，注意不能是本身
 * */
public class TwoSum {
    //    public int[] twoSum(int[] nums,int target){
//        //check if the nums is valid
//        if(null==nums||nums.length<=1){
//            return new int[2];
//        }
//
//        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int i =0;i<nums.length;i++){
//            map.put(target-nums[i],i);
//        }
//
//        for(int i =0;i<nums.length;i++){
//            Integer v = map.get(nums[i]);
//            //v exits and v cannot be itself
//            if(null!=v&&v!=i){
//                return new int[]{v+1,i+1};
//            }
//        }
//
//        return null;
//    }
    public int[] twoSum(int[] nums, int target) {
//        check validation
        if (nums == null || nums.length < 1) {
            return nums;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer v = map.get(nums[i]);
//            can't be itself
            if (v != null && v != i) {
                return new int[]{i , v};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] tmp = twoSum.twoSum(nums, target);
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(tmp[i] + " ");
        }
        System.out.println();
    }
}
