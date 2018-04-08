package com.julyerr.realInterview.exams.baidu.chunzhao2017;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 这道题目没有看清楚题目，题目中说明需要依次访问节点，一方面的暴力求解
 *
 *
 * */
public class GoHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int start = nums[0];
            int end = nums[n - 1];
            Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                if (nums[i] == start) {
                    start = i;
                }
                if (nums[i] == end) {
                    end = i;
                }
            }
            System.out.println(start + " " + end);
            int left = 0;
            int right = n - 1;
            if (start == left && end == right || start == right && end == left) {
                System.out.println(Math.abs(nums[right] - nums[left]));
            } else if (start == left || end == left) {
                right--;
            } else if (start == right || end == right) {
                left++;
            } else {
                if (nums[left + 1] - nums[left] >= nums[right] - nums[right - 1]) {
                    left++;
                } else {
                    right--;
                }
            }
            System.out.println(2 * (nums[right] - nums[left]) - Math.abs(nums[end] - nums[start]));
        }
    }
}
