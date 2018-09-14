package com.julyerr.leetcode.array;

/*
 * 参考思路：http://www.cnblogs.com/grandyang/p/5873525.html
 * 直接使用递归的方式，栈溢出；
 * n+1和n-1只有针对n+1之后是4的倍数情况使用+1，其他情况-1;
 * 而且防止出现运算溢出的情况
 * */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        int times = 0;
        long tmp = n;
        if (tmp == 1) {
            return times;
        }
        while (tmp > 1) {
            if ((tmp & 1) == 0) {
                tmp >>= 1;
            } else {
                if ((tmp & 2) !=0 && tmp != 3) {
                    tmp++;
                } else {
                    tmp--;
                }
            }
            times++;
        }
        return times;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerReplacement().integerReplacement(8));
    }
}
