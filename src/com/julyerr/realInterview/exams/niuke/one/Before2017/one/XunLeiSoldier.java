package com.julyerr.realInterview.exams.niuke.one.Before2017.one;

import java.util.Scanner;

/*
参考大神的解题思路：https://www.nowcoder.com/questionTerminal/79190c8e6202414bad33d6e287b61f3d
*
* 这道题目关键是理解题目意思，通俗的来说就是，从部队中挑选出一名战士，通过和其他人的斗争，可能获取到的最大值；
* 显然不能直接暴力，该战士只能与x<y（x代表战斗力，y代表潜能值）的人PK才能获取到经验值；
* 题目要求最大的x+y的值，通过比较可以求出战斗之后的sum(x-y)增量，还需要添加自己的能力值。
*
* 比较巧妙的地方就是，
* 1.如果该战士x<y的话，能力值已经计算过了，因此sum=sum-(y-x)+x+y=sum+2*x；
* 2.如果x>=y的话，sum = sum+x+y；
* 可以避免直接找到需要被训练的战士，只需要遍历中间过程找到x+y和2*x的最大值添加即可
* */
public class XunLeiSoldier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long sum = 0;
//            寻找的最大比较值
            long comparedVal = 0;
            for (int i = 0; i < n; i++) {
                long x = scanner.nextInt();
                long y = scanner.nextInt();
                if (x < y) {
//                    添加增量
                    sum += y - x;
                    comparedVal = Math.max(comparedVal, x + x);
                } else {
                    comparedVal = Math.max(comparedVal, x + y);
                }
            }
            System.out.println(comparedVal + sum);
        }
    }
}
