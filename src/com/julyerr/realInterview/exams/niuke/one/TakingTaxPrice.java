package com.julyerr.realInterview.exams.niuke.one;

import java.util.Scanner;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/893ad8352e21488f8a7c43e1c5bb34e1
 * 使用枚举法，遍历所有可能取到coin的种数，选择更新，参见代码注释
 * */
public class TakingTaxPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = scanner.nextInt();
            }

            int count = 0;
//            枚举每种情况
            for (int i = 0; i < Math.pow(2, n); i++) {
                int tmp = i;
                int tmpSum = 0;
                int minCoin = 1001;
                int tmpCount = 0;
                for (int j = 0; j < n; j++) {
//                    如果当前coin被取到
                    if (tmp % 2 != 0) {
                        tmpSum += prices[j];
                        minCoin = Math.min(minCoin, prices[j]);
                        tmpCount++;
                    }
                    tmp >>= 1;
                }
//                满足要求，同时数量变大才进行更新
                if (tmpSum >= s && tmpSum - minCoin < s && tmpCount > count) {
                    count = tmpCount;
                }
            }
            System.out.println(count);
        }
    }
}
