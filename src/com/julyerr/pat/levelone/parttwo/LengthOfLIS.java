package com.julyerr.pat.levelone.parttwo;

public class LengthOfLIS {
    //    N*N的时间复杂度
//    dp[i] 表示包含num[i]的最大连续递增子序列的长度
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length < 2) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int tmp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (j + 1 < tmp - 1) {
                    break;
                }
                if (nums[j] < nums[i]) {
                    tmp = Math.max(tmp, dp[j] + 1);
                }
            }
            dp[i] = tmp;
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    //    时间复杂度nlog(n)
//    dp[i]表示长度为i的最大递增子序列的最小末尾的值
    public int lengthOfLISII(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length < 2) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int index = findUpperIndex(dp, 0, max - 1, nums[i]);
            if (index == -1) {
                dp[max++] = nums[i];
            } else {
                dp[index] = nums[i];
            }
        }
        return max;
    }

    //    查找相等或者，大于key的第一个元素的下标
    private static int findUpperIndex(int[] nums, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
//        没有找到，返回-1
        if (left > end) {
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS.lengthOfLISII(nums));
    }
}
