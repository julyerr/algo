package com.julyerr.realInterview.exams.netease.neitui2018;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 参考资料：https://www.nowcoder.com/questionTerminal/d996665fbd5e41f89c8d280f84968ee1
 * 关键是最大和最小的值组成一对
 * */
public class CrazyQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);

            int diff = nums[n - 1] - nums[0];
            int max = nums[n - 1];
            int min = nums[0];
            int maxIndex = n - 2;
            int minIndex = 1;
//            没有到尽头，有超过一个元素可以添加
            while (minIndex < maxIndex) {
                diff += max - nums[minIndex];
                diff += nums[maxIndex] - min;
                max = nums[maxIndex--];
                min = nums[minIndex++];
            }
//            minIndex = maxIndex,只有一个元素添加，左端还是右端
            diff += Math.max(max - nums[minIndex], nums[maxIndex] - min);
            System.out.println(diff);
        }
    }
}
