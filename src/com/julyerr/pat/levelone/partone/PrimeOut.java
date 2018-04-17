package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

/*
 * 开始看错了题目，求N-M个素数，想不出更好的方法只能暴力求解了;
 * 然后注意输出格式调整
 * */

public class PrimeOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int count = 0;
            int start = 1;
            int tmp = 0;
            while (true) {
                start++;
                if (isPrime(start)) {
                    count++;
                    if (count >= N) {
                        tmp = count - N;
                        if (tmp % 10 == 0) {
                            System.out.print(start);
                        } else if (tmp % 10 == 9) {
                            System.out.println(" " + start);
                        } else {
                            System.out.print(" " + start);
                        }
                        if (count == M) {
                            break;
                        }
                    }
                }
            }
            if (tmp != 9) {
                System.out.println();
            }
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
