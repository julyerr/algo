package com.julyerr.realInterview.exams.netease.one0327;

import java.util.Scanner;

/*
 * 解题思路参见：https://blog.csdn.net/deepseazbw/article/details/79522116
 *
 * 主要是处理好余数和倍数的关系
 * */
public class Kinds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            long times = 0;
            if(k==0){
                times = n;
                System.out.println(times*times);
            }else{
//            i是被除数
                for (int i = k + 1; i <= n; i++) {
                    times += (n / i) * (i - k);
                    if (n % i >= k) {
                        times += n % i - k + 1;
                    }
                }
                System.out.println(times);
            }
        }
    }
}
