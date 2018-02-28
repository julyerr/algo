package com.julyerr.leetcode.array;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * <p>
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */


import java.util.*;

/**
 * solution :
 * 对数组进行排序；
 * start从0到n-1，对num[start]求另外两个数，这里用mid和end；
 * mid指向start+1，q指向结尾。sum = num[start] + num[mid]+ num[end]；
 * 利用加逼定理求解，终止条件是mid == end；
 * 顺带去重
 */
public class ThreeSum {
    public List<List<Integer>> threeSums(int[] nums) {
        //check if the nums is valid
        if (nums == null || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }


        //searchSort the nums array
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int start = 0; start < nums.length - 2; start++) {

            //grep the repeated elem
            if (start != 0 && nums[start - 1] == nums[start]) {
                continue;
            }
            int mid = start + 1, end = nums.length - 1;
            while (mid < end) {
                int sum = nums[start] + nums[mid] + nums[end];
                //compare the sum and move the cursor at the two end
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[start]);
                    tmp.add(nums[mid]);
                    tmp.add(nums[end]);
                    set.add(tmp);

                    while (++mid < end && nums[mid - 1] == nums[mid]) ;
                    while (--end > mid && nums[end] == nums[end + 1]) ;

                }else if(sum<0){
                    mid++;
                }else{
                    end--;
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }
}
