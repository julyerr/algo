package com.julyerr.niuke;

import java.util.Scanner;


/*
 * 根据题目意思，显然直接排序计算会出现内存溢出的情况；
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/6c9d8d2e426c4c58bbadfdf67d591696
 *
 * 迭代分别计算出以1.2...开头的在n范围之内的数字个数，如果m处在k开头的范围之内，去除k然后迭代k[0]的情况；
 * 如果m处在k开头的范围之外，次数减去以k开头的总次数，k++,然后重新迭代判断。
 * */
public class NthDict {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long n =scanner.nextLong();
            long m =scanner.nextLong();
            System.out.println(nthDict(n,m));
        }
    }

    private static long nthDict(long n, long m) {
        int prefix = 1;
        while (m != 0) {
            long tmpSum = getN(prefix, n);
//            在prefix开头范围之内
            if (tmpSum >= m) {
                m--;
                if (m == 0) {
                    break;
                }
                prefix *= 10;
            } else {
                m -= tmpSum;
                prefix++;
            }
        }
        return prefix;
    }

    //    获取prefix开头<=n的个数
    private static long getN(long prefix, long n) {
        int step = 10;
        int cnt = 1;
        for (; step * prefix <= n; step *= 10) {
            if (prefix * step - 1 + step < n) {
                cnt += step;
            } else {
                cnt += n + 1 - prefix * step;
            }
        }
        return cnt;
    }
}
