package com.julyerr.niuke.company.tencent;

import java.util.Scanner;

/*
从后往前判断，如果发现前者是大写字母，进行交换
* */
public class AlphaMove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.next();
            int right = string.length() - 1;
            StringBuilder stringBuilder = new StringBuilder(string);
            while (right >= 0) {
//                已经是大写
                if (Character.isUpperCase(stringBuilder.charAt(right))) {
                    right--;
                } else {
                    int left = right - 1;
//                    找到前驱的小写
                    while (left >= 0 && Character.isLowerCase(stringBuilder.charAt(left))) {
                        left--;
                    }
                    if (left < 0) {
                        break;
                    } else {
//                        两两进行交换
                        while (left < right) {
                            char tmp = stringBuilder.charAt(left);
                            stringBuilder.setCharAt(left, stringBuilder.charAt(left + 1));
                            stringBuilder.setCharAt(++left, tmp);
                        }
                        right--;
                    }
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
