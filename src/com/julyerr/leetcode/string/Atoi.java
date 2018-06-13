package com.julyerr.leetcode.string;

public class Atoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        long rt = 0;
        int index = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        boolean minus = false;
        if (index < str.length()) {
            if (str.charAt(index) == '-') {
                minus = true;
                index++;
            } else if (str.charAt(index) == '+') {
                index++;
            }
            for (int i = index; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    rt = rt * 10 + str.charAt(i) - '0';
                    if (rt > Integer.MAX_VALUE) {
                        return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    }
                } else {
                    break;
                }
            }
        }
        return (int) (minus ? -rt : rt);
    }
}
