package com.julyerr.targetOffer.string;


/**
 * 实现一个函数，把字符串中的每个空格都替换成“%20”，
 * 已知原位置后面有足够的空余位置，要求改替换过程发生在原来的位置上。
 */

/**
 * 解题思路：
 * 如果直接对每个空格字符均需要移动的话，效率很低
 * 开辟一个新的空间针对空格特殊处理（myself idea)
 * 原作者想法很巧妙，先记录添加%20的总长度，然后从后面扫描到前面，不需要开辟空间
 */
public class ReplaceBlank {
    public static void replaceBlankI(char[] chars, int length) {
        if (length == 0) {
            return;
        }
        int index = 0;
        int newIndex = length;
        for (int i = 0; i < length; i++) {
//            记录空格出现的位置
            if (chars[i] == ' ') {
            }
        }
        for (int i = 0; i < length; i++) {
            if (chars[i] != ' ') {
                chars[newIndex++] = chars[i];
            } else {
                chars[newIndex++] = '%';
                chars[newIndex++] = '2';
                chars[newIndex++] = '0';
            }
        }
        for (int i = length; i < newIndex; i++) {
            chars[i - length] = chars[i];
//            清空后面出现的字符
            chars[i] = ' ';
        }
    }

    public static void replaceBlank(char[] chars, int length) {
//        check validation
        if (length == 0) {
            return;
        }
        int newLength = length;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                newLength += 2;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                chars[newLength--] = chars[i];
            } else {
                chars[newLength--] = '0';
                chars[newLength--] = '2';
                chars[newLength] = '%';
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[40];
        char[] temp = "  y o u ".toCharArray();
        System.out.println(temp);
        for (int i = 0; i < temp.length; i++) {
            chars[i] = temp[i];
        }
        replaceBlank(chars, 11);
        String str1 = new String(chars);
        System.out.println(str1);
    }
}
