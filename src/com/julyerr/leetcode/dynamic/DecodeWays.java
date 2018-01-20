package com.julyerr.leetcode.dynamic;


/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p>
 * The number of ways decoding "12" is 2.
 */
//注意非零的情况之下只能保存前述结果，不能增加
public class DecodeWays {
    public int decodingWays(String s) {
        int length = s.length();
        if (length == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        int step0, step1, step2;
        step0 = step1 = 1;
        step2 = 0;
        for (int i = 1; i < length; i++) {
            char a = s.charAt(i - 1);
            char b = s.charAt(i);
            int tmp = (a - '0') * 10 + (b - '0');
            if (b != '0') {
                step2 = step1;
                if (a != '0' && tmp <= 26) {
                    step2 += step0;
                }
            } else if (a != '0' && tmp <= 26) {
                step2 = step0;
            } else {
                step2 = 0;
            }
            step0 = step1;
            step1 = step2;
        }
        return step2;
    }

    public static void main(String[] args) {
        DecodeWays decodeWay = new DecodeWays();
        System.out.println(decodeWay.decodingWays("110"));
        System.out.println(decodeWay.decodingWays("10"));
        System.out.println(decodeWay.decodingWays("11"));
        System.out.println(decodeWay.decodingWays("10000"));
    }
}
