package com.julyerr.realInterview.exams.niuke.one.One2017;

import java.util.Scanner;

/*
* 利用高斯公司对长度l进行遍历暴力求解
* */
public class Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt() * 2;
            int l = scanner.nextInt();
            int start = 0;
//            数组的长度从小到大遍历计算
            for (int i = l; i <= 100; i++) {
//                不可能
                if (n % i != 0) {
                    continue;
                } else {
                    int tmp = n / i;
//                    不可能
                    if ((tmp - i + 1) % 2 != 0) {
                        continue;
//                        只要得到结果，肯定是最小的
                    } else {
                        start = (tmp - i + 1) / 2;
                        l = i;
                        break;
                    }
                }
            }
            if (start == 0) {
                System.out.println("No");
            } else {
                System.out.print(start);
                for (int i = start + 1; i < start + l; i++) {
                    System.out.print(" " + i);
                }
                System.out.println();
            }
        }
    }
}
