package com.julyerr.targetOffer.string;

/**
 * 实现一个函数完成字符串的左旋转功能。比如，输入abcdefg和数字2，输出为cdefgab。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？
 */

/**
 * stringBuilder直接搞定
 */
public class RotateStr {
    public String LeftRotateString(String str, int n) {
//        check validation
        if (str == null || str.length() == 0 || n <= 0 || n == str.length()) {
            return str;
        }
        n = n % str.length();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.substring(n));
        stringBuilder.append(str.substring(0, n));
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RotateStr rotateStr = new RotateStr();
        System.out.println(rotateStr.LeftRotateString("abcXYZdef", 3));
    }
}
