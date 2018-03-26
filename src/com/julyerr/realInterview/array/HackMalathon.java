package com.julyerr.realInterview.array;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/acb888f7ccee4fc0aab208393d41a552
 *
 * 先从左到右扫描一遍，发现大的就++；然后从右往左扫面一遍，遇到大的就++；
 * */
public class HackMalathon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            int[] money = new int[N];
            Arrays.fill(money, 1);
//            从左往右计算
            for (int i = 0; i < N - 1; i++) {
                if (nums[i + 1] > nums[i]) {
                    money[i + 1] = money[i] + 1;
                }
            }

//            从右往左计算
            for (int i = N - 1; i > 0; i--) {
                if (nums[i] < nums[i - 1] && money[i - 1] < money[i] + 1) {
                    money[i - 1] = money[i] + 1;
                }
            }
            int sum = 0;
//            合并输出
            for (int i = 0; i < N; i++) {
                sum += money[i];
            }
            System.out.println(sum);
        }
    }
}
