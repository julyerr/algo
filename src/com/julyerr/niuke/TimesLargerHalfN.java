package com.julyerr.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
* 题目描述
输入n个整数，输出出现次数大于等于数组长度一半的数。
输入描述:
每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
输出描述:
输出出现次数大于等于n/2的数。
示例1
输入

3 9 3 2 5 6 7 3 2 3 3 3
输出

3
* */
public class TimesLargerHalfN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strings = line.split(" ");
            Map<String, Integer> map = new HashMap<>();
            int len = strings.length;
            for (int i = 0; i < len; i++) {
                int tmp = 0;
                if (map.get(strings[i]) != null) {
                    tmp = map.get(strings[i]);
                    if (tmp >= len / 2 - 1) {
                        System.out.println(strings[i]);
                        break;
                    }
                }
                map.put(strings[i], tmp + 1);
            }
        }
    }
}
