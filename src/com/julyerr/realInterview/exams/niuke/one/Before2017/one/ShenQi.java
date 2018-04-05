package com.julyerr.realInterview.exams.niuke.one.Before2017.one;

import java.util.Scanner;

/*
 * 想不到更好的办法只能暴力求解了,遍历[a,b]中每个数，然后任取两位判断组成的二位数是否是质数
 * */
public class ShenQi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int count = 0;
            for (int i = a; i <= b; i++) {
//                通过字符转换
                String tmp = i + "";
                boolean flag = false;
//                任意取两位
                for (int j = 0; j < tmp.length() - 1; j++) {
                    for (int k = j + 1; k < tmp.length(); k++) {
                        int first = (tmp.charAt(j) - '0') * 10 + tmp.charAt(k) - '0';
//                        必须构成二位数
                        if (first > 10 && isPrime(first)) {
                            count++;
                            flag = true;
                        } else {
                            int second = (tmp.charAt(k) - '0') * 10 + tmp.charAt(j) - '0';
                            if (second > 10 && isPrime(second)) {
                                count++;
                                flag = true;
                            }
                        }
//                        符合条件直接跳出
                        if (flag) {
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
