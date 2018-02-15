package com.julyerr.niuke;

import java.util.*;

/*
题目描述
某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
输入描述:
输入包括m+2行。
 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
输出描述:
输出一个整数,表示最大的总预计消费金额
示例1
输入

3 5 2 4 2 1 3 3 5 3 7 5 9 1 10
输出

20
* */

/*
 * 解题思路还是比较容易想到的
 *     优先服务那些消费量大的顾客
 * 自己实现使用list的remove进行删除效率比较低，参考大神的优先级队列的解题思路，至少没有超时
 * */

public class Restraunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            long ret = 0;
            int[] chairs = new int[n];
            for (int i = 0; i < n; i++) {
                chairs[i] = scanner.nextInt();
            }
            List<Tourist> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int num = scanner.nextInt();
                int money = scanner.nextInt();
            }

            System.out.println(ret);
        }
    }

    class Tourist {
        int num;
        int money;

        public Tourist(int num, int money) {
            this.num = num;
            this.money = money;
        }
    }
}
