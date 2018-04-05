package com.julyerr.realInterview.exams.niuke.one.Before2017.one;

import java.util.Scanner;

/*
 * 直接比较已有字符串中不相等的个数即可
 * */
public class MaxSameLen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String A = scanner.next();
            String B = scanner.next();

            int min = Integer.MAX_VALUE;
//            以A为模式串
            for (int i = 0; i <= B.length() - A.length(); i++) {
                int tmp = 0;
                for (int j = 0; j < A.length(); j++) {
                    if (A.charAt(j) != B.charAt(i + j)) {
                        tmp++;
                    }
                }
//                如果是子串的话，肯定为0
                min = Math.min(min, tmp);
                if (min == 0) {
                    break;
                }
            }
            System.out.println(min);
        }
    }


}
/*
adaabc
aababbc
2



* */