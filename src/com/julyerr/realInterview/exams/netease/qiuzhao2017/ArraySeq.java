package com.julyerr.realInterview.exams.netease.qiuzhao2017;

import java.util.Scanner;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/0147cbd790724bc9ae0b779aaf7c5b50
 *
 * 使用递归，数组两端的数一定要相等或者合并成同一个数
 * */
public class ArraySeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(dfs(nums, 0, nums.length - 1));
        }
    }

    private static int dfs(int[] nums, int start, int end) {
        int left = nums[start];
        int right = nums[end];
        int times = 0;
//        数组两端相等或者合并成同一个数
        while (start < end && left != right) {
            if (left < right) {
                left += nums[++start];
            } else {
                right += nums[--end];
            }
            times++;
        }
        if (start >= end) {
            return times;
        }
        times += dfs(nums, ++start, --end);
        return times;
    }
}
