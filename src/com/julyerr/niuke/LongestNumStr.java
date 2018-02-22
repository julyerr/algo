package com.julyerr.niuke;

import java.util.Scanner;

/*
* 题目描述
读入一个字符串str，输出字符串str中的连续最长的数字串
输入描述:
个测试输入包含1个测试用例，一个字符串str，长度不超过255。
输出描述:
在一行内输出str中里连续最长的数字串。
示例1
输入

abcd12345ed125ss123456789
输出

123456789
* */

/*
 * 每次比较end-start的值即可
 * */
public class LongestNumStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int start, end;
            start = end = -1;

            boolean prevNum = false;
            int maxLen = 0;
            int maxStart = -1;
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    if (prevNum) {
                        end++;
                    } else {
                        start = end = i;
                        prevNum = true;
                    }
                    if (end + 1 - start > maxLen) {
                        maxLen = end + 1 - start;
                        maxStart = start;
                    }
                } else {
                    prevNum = false;
                }
            }

            if (maxStart == -1) {
                System.out.println();
            } else {
                System.out.println(str.substring(maxStart, maxStart + maxLen));
            }
        }
    }
}
