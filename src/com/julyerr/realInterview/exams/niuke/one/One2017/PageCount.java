package com.julyerr.realInterview.exams.niuke.one.One2017;

import java.util.Scanner;

/*
 * 本文内容主要参考：https://blog.csdn.net/zjkc050818/article/details/66474150
 * 关键之处在于针对不同的位置分别统计可能出现的的次数，然后汇总返回
 * */
public class PageCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] count = new int[10];
            help(count, n);
            System.out.print(count[0]);
            for (int i = 1; i < 10; i++) {
                System.out.print(" " + count[i]);
            }
            System.out.println();
        }
    }

    private static void help(int[] count, int n) {
        for (int i = 1; n / i >= 1; i *= 10) {
            int before = n / (i * 10);
            int current = n % (i * 10) / i;
            int after = n % i;

//            针对0进行特殊处理
            if (current == 0) {
                count[0] += (before - 1) * i + after + 1;
            } else {
                count[0] += before * i;
            }

//            对于1-9的元素进行统计
            for (int j = 1; j < 10; j++) {
                if (j < current) {
//                    对于0这种情况需要增加1处理
                    count[j] += (1 + before) * i;
                } else if (j == current) {
                    count[j] += before * i + after + 1;
                } else {
                    count[j] += before * i;
                }
            }
        }
    }
}
