package com.julyerr.niuke;

import java.util.Scanner;

/*
* 题目描述
小易喜欢的单词具有以下特性：
1.单词每个字母都是大写字母
2.单词没有连续相等的字母
3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，子序列可能不连续。
例如：
小易不喜欢"ABBA"，因为这里有两个连续的'B'
小易不喜欢"THETXH"，因为这里包含子序列"THTH"
小易不喜欢"ABACADA"，因为这里包含子序列"AAAA"
小易喜欢"A","ABA"和"ABCBA"这些单词
给你一个单词，你要回答小易是否会喜欢这个单词。
输入描述:
输入为一个字符串，都由大写字母组成，长度小于100
输出描述:
如果小易喜欢输出"Likes",不喜欢输出"Dislikes"
示例1
输入

AAA
输出

Dislikes
* */
public class LikesStrsXiaoyi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LikesStrsXiaoyi likesStrsXiaoyi = new LikesStrsXiaoyi();
        while (scanner.hasNext()) {
            String string = scanner.next();
            System.out.println(likesStrsXiaoyi.likes(string) ? "Likes" : "Dislikes");
        }
    }

    public boolean likes(String string) {
//      easy check first
        int length = string.length();
        for (int i = 0; i < length - 1; i++) {
            if (!Character.isUpperCase(string.charAt(i)) || string.charAt(i) == string.charAt(i + 1)) {
                return false;
            }
        }
        if (!Character.isUpperCase(string.charAt(length - 1))) {
            return false;
        }
//        check for child sequence
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                for (int k = j + 1; k < length - 1; k++) {
                    char firPre = string.charAt(i);
                    char firPos = string.charAt(k);
                    if (firPre == firPos) {
                        char secPre = string.charAt(j);
                        for (int l = k + 1; l < length; l++) {
                            if (string.charAt(l) == secPre) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
