package com.julyerr.leetcode.array;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

/**
 * similar to the three sum problem,while not for the list result but for the sum of the result
 */
public class ThreeClosest {
    public int threeSumClosest(int[] nums, int target) {
        //check if the nums is valid
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        //sor the nums array
        Arrays.sort(nums);

        int result = 0;
        int minGap = Integer.MAX_VALUE;
        for (int start = 0; start < nums.length - 2; start++) {
            //declare the two cursor
            int mid = start + 1, end = nums.length - 1;
            while (mid < end) {
                int sum = nums[start] + nums[mid] + nums[end];

                // compare the gap , whether to update the result
                int gap = Math.abs(sum - target);
                if (gap < minGap) {
                    minGap = gap;
                    result = sum;
                    if (gap == 0) {
                        return target;
                    }
                }
                if (sum < target) {
                    mid++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
