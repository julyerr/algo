package com.julyerr.niuke.company.tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/test/question/done?tid=14398055&qid=44802
 * 计算原字符串和其逆序字符串的最大公共子序列（不是最大公共子串）
 * */
public class DeleteChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string1 = scanner.next();
            StringBuilder sb = new StringBuilder();
//            逆序
            for (int i = string1.length() - 1; i >= 0; i--) {
                sb.append(string1.charAt(i));
            }
            String string2 = sb.toString();
            System.out.println(string1.length() - longestCommonSequence(string1, string2));
        }
    }

    //    两个字串的最大公共子序列长度
    private static int longestCommonSequence(String string1, String string2) {
        int length1 = string1.length();
        int length2 = string1.length();
        int[][] matrix = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < length1; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 0; i < length2; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[length1][length2];
    }
}
