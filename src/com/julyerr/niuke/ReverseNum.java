package com.julyerr.niuke;

import java.util.Scanner;

/*
* 题目描述
对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
如果 X = 123，则rev(X) = 321;
如果 X = 100，则rev(X) = 1.
现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
输入描述:
输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。
输出描述:
输出rev(rev(x) + rev(y))的值
示例1
输入

123 100
输出

223
* */

/*
 * 简单的对位数的反转
 * */
public class ReverseNum {
    public static void main(String[] args) {
        ReverseNum reverseNum = new ReverseNum();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(reverseNum.rev(reverseNum.rev(m) + reverseNum.rev(n)));
        }
    }

    private int rev(int n) {
        if (n == 0) {
            return n;
        }
        boolean firstZero = true;
        int ret = 0;
        while (n > 0) {
            ret = ret * 10 + n % 10;
            n /= 10;
        }
        return ret;
    }
}
