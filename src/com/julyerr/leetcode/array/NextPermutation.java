package com.julyerr.leetcode.array;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
//        check validation
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        int p = 0;
//        从右到左，找到第一个nums[i] < nums[i+1]的数
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }

        int q = 0;
//        从右到左，找到第一个nums[i] > nums[p]
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] > nums[p]) {
                q = i;
                break;
            }
        }

//        如果是最后一种排列情况
        if (p == 0 && q == 0) {
            reverse(nums, 0, length - 1);
            return;
        }

//        swap p and q
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;

//        防止数组越界访问
        if (p < length - 1) {
            reverse(nums, p + 1, length - 1);
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
//        int[] nums = new int[]{1,2,3};
        int[] nums = new int[]{23, 3, 1};

        nextPermutation.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
