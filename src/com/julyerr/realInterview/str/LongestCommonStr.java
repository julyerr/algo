package com.julyerr.realInterview.str;

import java.util.Scanner;

/*
求解两个字符串的最长公共子串，使用矩阵法，只有两个字符相等的时候char[i][j] = char[i-1][j-1]+1,负责赋值为0
* */
public class LongestCommonStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            System.out.println(LCS(first, second));
        }
    }

    public static int LCS(String str1, String str2) {
        int[][] c = new int[str1.length() + 1][str2.length() + 1];

        int length = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    length = Math.max(length, c[i][j]);
                } else {
                    c[i][j] = 0;
                }
            }
        }
        return length;
    }
}


/*
* aaaaaaaabaafdh
abafdh
* */