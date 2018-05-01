package com.julyerr.leetcode.dynamic;

public class CountUniqueNumbers {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        }
        int rt = 10;
//        最高位只能从1-9中取，多一个位数，最低位可以变化的位数相应的减少一
        int tmp = 9;
        for (int i = 2; i <= n; i++) {
            tmp *= (9 - i + 2);
            rt += tmp;
        }
        return rt;
    }
}
