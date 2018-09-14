package com.julyerr.leetcode.array;

/*
 * 参考解题思路： https://blog.csdn.net/MebiuW/article/details/52713918
 * 使用递归和辗转的方式进行
 * 当然也可以模拟的方式暴力处理
 * */
public class LastRemaining {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
