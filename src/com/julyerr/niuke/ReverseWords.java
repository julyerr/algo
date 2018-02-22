package com.julyerr.niuke;

import java.util.Scanner;

/*
* 题目描述
将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
输入描述:
每个测试输入包含1个测试用例： I like beijing. 输入用例长度不超过100
输出描述:
依次输出倒置之后的字符串,以空格分割
示例1
输入

I like beijing.
输出

beijing. like I
* */
public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strings = line.split(" ");
            int length = strings.length;
            int left = 0;
            int right = length - 1;
            while (right >= left) {
                String tmp = strings[left];
                strings[left] = strings[right];
                strings[right] = tmp;
                left++;
                right--;
            }
            for (int i = 0; i < length - 1; i++) {
                System.out.print(strings[i] + " ");
            }
            System.out.println(strings[length - 1]);
        }
    }
}
