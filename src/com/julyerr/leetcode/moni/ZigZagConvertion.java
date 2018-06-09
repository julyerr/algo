package com.julyerr.leetcode.moni;

/*
 * 解题思路参考：http://www.cnblogs.com/AlvinZH/p/8549899.html
 * 使用模拟的方式
 * */
public class ZigZagConvertion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int step = (numRows << 1) - 2;
//        每一行
        for (int i = 0; i < numRows; i++) {
//            每一行中的每一列（|）
            for (int j = i; j < s.length(); j += step) {
                stringBuilder.append(s.charAt(j));
//                针对（/），计算偏移量
                int k = j + step - (i << 1);
                if (i != 0 && i != numRows - 1 && k < s.length()) {
                    stringBuilder.append(s.charAt(k));
                }
            }
        }
        return stringBuilder.toString();
    }
}