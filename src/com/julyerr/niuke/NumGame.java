package com.julyerr.niuke;

/*
题目描述
小易邀请你玩一个数字游戏，小易给你一系列的整数。你们俩使用这些整数玩游戏。每次小易会任意说一个数字出来，然后你需要从这一系列数字中选取一部分出来让它们的和等于小易所说的数字。 例如： 如果{2,1,2,7}是你有的一系列数，小易说的数字是11.你可以得到方案2+2+7 = 11.如果顽皮的小易想坑你，他说的数字是6，那么你没有办法拼凑出和为6 现在小易给你n个数，让你找出无法从n个数中选取部分求和的数字中的最小数。
输入描述:
输入第一行为数字个数n (n ≤ 20)
第二行为n个数xi (1 ≤ xi ≤ 100000)
输出描述:
输出最小不能由n个数选取求和组成的数
示例1
输入

3
5 1 2
输出

4
* */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 解题思路太巧秒了，第一次肯定做不出来，参考别人的解题思路
 * https://www.nowcoder.net/questionTerminal/876e3c5fcfa5469f8376370d5de87c06
 */
public class NumGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            int miss = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > miss + 1) {
                    break;
                } else {
                    miss += nums[i];
                }
            }
            System.out.println(miss + 1);
        }
    }
}
