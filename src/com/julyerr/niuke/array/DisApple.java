package com.julyerr.niuke.array;

/**
 * 题目描述
 * n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每
 * 一次，你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。
 * 输出描述:
 * 输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
 */

import java.util.Scanner;

/**
 * 终于做到一道比较有信心的题目（前面题目有点难度，醉了）
 * 只需要先求解除平均数，判断差值即可
 */
public class DisApple {
    public int times(int[] nums) {
//        check validation
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
//        不能整除直接返回
        if (sum % length != 0) {
            return -1;
        }
        int average = sum / length;
        int total = 0;
        for (int i = 0; i < length; i++) {
            int tmp = average - nums[i];
            if (tmp % 2 != 0) {
                return -1;
            }
//            只需要针对大于或者小于平均值的所有元素统计次数
            if (nums[i] < average) {
                total += average - nums[i];
            }
        }
        return total / 2;
    }

    public static void main(String[] args) {
        DisApple disApple = new DisApple();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(disApple.times(nums));
        }
    }
}
