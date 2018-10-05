package com.julyerr.leetcode.string;

/*
 * 参考思路：https://leetcode-cn.com/problems/remove-k-digits/description/
 * */

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                k--;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
        }
//        删除多余的元素
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        int index = 0;
        while (index < sb.length() && sb.charAt(index++) == '0') ;
        return sb.substring(index - 1).toString();
    }

    public static void main(String[] args) {
        String num = "112";
        int k = 1;
        System.out.println(new RemoveKDigits().removeKdigits(num, k));
    }
}