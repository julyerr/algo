package com.julyerr.niuke;

import java.util.Scanner;

/*
* 题目描述
小易是一个数论爱好者，并且对于一个数的奇数约数十分感兴趣。一天小易遇到这样一个问题：
定义函数f(x)为x最大的奇数约数，x为正整数。 例如:f(44) = 11.
现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
例如： N = 7
f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
小易计算这个问题遇到了困难，需要你来设计一个算法帮助他。
输入描述:
输入一个整数N (1 ≤ N ≤ 1000000000)
输出描述:
输出一个整数，即为f(1) + f(2) + f(3).......f(N)
示例1
输入

7
输出

21
* */


/*
 * 想到使用动态规划,但是如果n比较大的话容易造成内存溢出,
 * 于是直接暴力求解超时
 * 参考大神的解题思路
 *  https://www.nowcoder.com/questionTerminal/49cb3d0b28954deca7565b8db92c5296
 * 1,2,3,4,5,6,7,8,9,10为例:
 *  1,3,5,7,9 可以直接相加,剩余的2,4,6,8,10等效于1,2,3,4,5的求解结果
 * 1,2,3,4,5
 *  1,3,5可以直接相加,剩余的2,4等效于1,2的求解结果
 *  ...
 * */
public class OddDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long sum = 0;
            for (int i = n; i > 0; i /= 2) {
                long tmp = (i + 1) / 2;
                sum += tmp * tmp;
            }
            System.out.println(sum);
        }
    }
}
