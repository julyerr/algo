package com.julyerr.niuke;

import java.util.Scanner;

/*
 * 10 的个数其实就是5的质因子的个数
 * 参考解题思路：
 * https://www.nowcoder.com/questionTerminal/6ffdd7e4197c403e88c6a8aa3e7a332a
 * */
public class ZeroNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int count = 0;
            while (n > 0) {
                count += n / 5;
                n /= 5;
            }
            System.out.println(count);
        }
    }
}
