package com.julyerr.leetcode.dynamic;

/*
 * dp[i]表示target=i时的排列数，dp[i] += dp[j-nums[i]];
 * */
public class CombinationIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
//        下面这种方式没有将子问题求解完全
        //        dp[0] = 1;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = nums[i]; j <= target; j++) {
//                dp[j] += dp[j - nums[i]];
//            }
//        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationIV combinationIV = new CombinationIV();
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        System.out.println(combinationIV.combinationSum4(nums, target));
    }
}
