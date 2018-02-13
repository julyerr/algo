package com.julyerr.niuke;

import java.util.Scanner;

/*
* 题目描述
小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
输入描述:
输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果
输出描述:
输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1
示例1
输入

20
输出

3
* */

/*
 * 不断调整n/8 和 n/6 之间的平衡关系
 * */
public class PurchaseApple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int num8 = n / 8;
            int tmp = n - num8 * 8;
            int num6 = tmp / 6;
            tmp = tmp % 6;
            while (num8 > 0 && tmp % 6 != 0) {
                num8--;
                num6++;
                tmp += 2;
            }
            if (tmp % 6 != 0) {
                System.out.println(-1);
            } else {
                System.out.println(num6 + num8 + tmp / 6);
            }
        }
    }
}
