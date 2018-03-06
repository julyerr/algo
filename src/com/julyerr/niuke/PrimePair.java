package com.julyerr.niuke;

/*
题目描述
给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
输入描述:
输入包括一个整数n,(3 ≤ n < 1000)
输出描述:
输出对数
示例1
输入

10
输出

2
* */

import java.util.Arrays;
import java.util.Scanner;

/*
 *
 * 参考大神的解题思路:https://www.nowcoder.com/questionTerminal/c96d6acc025541ffb79c579688f8d003
 *
 * 输入的范围不是很大可以设置一个数组nums[n];
 * 筛选出范围的素数，然后判断和为输入参数即可
 * */
public class PrimePair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[1000];
        Arrays.fill(nums, 1);
//        倍数法，筛选出1000之内的素数
        for (int i = 2; i < 1000; i++) {
            for (int j = 2; i * j < 1000; j++) {
                nums[i * j] = 0;
            }
        }

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int ret = 0;
            for (int i = 2; i <= n / 2; i++) {
                if (nums[i] != 0 && nums[n - i] != 0) {
                    ret++;
                }
            }
            System.out.println(ret);
        }
    }
}
