package com.julyerr.niuke;

import java.util.Scanner;

/**
 * 题目描述
 * 牛牛拿到了一个藏宝图，顺着藏宝图的指示，牛牛发现了一个藏宝盒，藏宝盒上有一个机关，机关每次会显示两个字符串 s 和 t，
 * 根据古老的传说，牛牛需要每次都回答 t 是否是 s 的子序列。
 * 注意，子序列不要求在原字符串中是连续的，例如串 abc，它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种。
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例包含两行长度不超过 10 的不包含空格的可见 ASCII 字符串。
 * 输出描述:
 * 输出一行 “Yes” 或者 “No” 表示结果。
 * 示例1
 * 输入
 * <p>
 * x.nowcoder.com
 * ooo
 * 输出
 * <p>
 * Yes
 */

/**
 * 开始没有清晰理解题目的意思，直接map发现报错
 * 注意题目虽然不要求是连续的，但是明确的是有序的;
 * 设置一个index对s进行遍历
 */
public class TreasureMap {
    public boolean treasureMap(String s, String p) {
//        check validation
        if (s.length() < p.length()) {
            return false;
        }
        int index = 0;
        int pLen = p.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == p.charAt(index)) {
                index++;
                if (index >= pLen) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreasureMap treasureMap = new TreasureMap();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            String p = scanner.next();
            System.out.println(treasureMap.treasureMap(s, p) ? "Yes" : "No");
        }
    }
}
