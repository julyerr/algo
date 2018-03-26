package com.julyerr.realInterview.exams.netease;

import java.util.Scanner;

public class ReverseNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int tmp = n;
            while (tmp > 0) {
                if (tmp % 10 != 0) {
                    break;
                }
                tmp /= 10;
            }
            int sum = Integer.parseInt(new StringBuilder().append(tmp).reverse().toString()) + n;
            System.out.println(sum);
        }
    }
}
