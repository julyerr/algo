package com.julyerr.realInterview.exams.qunar;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 思路还是容易想到的，只是直接使用递归的话，超时，改用枚举集合即可
 * */
public class PingTicket {
    //    枚举元素值
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            boolean flag = false;
//            枚举其中每种组合情况
            for (int i = 0; i < 1 << (n); i++) {
                int tmp = i;
                int tmpSum = 0;
                for (int j = 0; j < n; j++) {
                    if ((tmp & (1 << j)) != 0) {
                        tmpSum += nums[j];
                    }
                }
                if (tmpSum == sum) {
                    System.out.println("perfect");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("good");
            }
        }
    }
    //    直接使用dfs超时
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            int count = scanner.nextInt();
//            int[] nums = new int[n];
//            for (int i = 0; i < n; i++) {
//                nums[i] = scanner.nextInt();
//            }
//            Arrays.sort(nums);
//            System.out.println(dfs(nums, count, 0) ? "perfect" : "good");
//        }
//    }
//
//    private static boolean dfs(int[] nums, int target, int start) {
//        if (start > nums.length) {
//            return false;
//        }
//        if (target == 0) {
//            return true;
//        }
//        for (int i = start; i < nums.length; i++) {
//            if (nums[i] > target) {
//                continue;
//            }
//            if (dfs(nums, target - nums[i], i + 1)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
/*

5 100
10 20 30 40 50

5 200
100 30 20 110 120
* */
