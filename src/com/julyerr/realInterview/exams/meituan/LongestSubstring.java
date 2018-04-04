package com.julyerr.realInterview.exams.meituan;

public class LongestSubstring {
    public int findLongest(String str1, int n, String str2, int m) {
        // write code here
        int[][] c = new int[str1.length() + 1][str2.length() + 1];
        for (int row = 0; row <= str1.length(); row++)
            c[row][0] = 0;
        for (int column = 0; column <= str2.length(); column++)
            c[0][column] = 0;

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
