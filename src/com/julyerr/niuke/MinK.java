package com.julyerr.niuke;

import java.util.Arrays;
import java.util.Scanner;

/*
* 题目描述
找出n个数里最小的k个
输入描述:
每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n
不超过100。
输出描述:
输出n个整数里最小的k个数。升序输出
示例1
输入

3 9 6 8 -10 7 -11 19 30 12 23 5
输出

-11 -10 3 6 7
* */

/*
 * 题目难道是不难，关键是处理输出的数据
 * */
public class MinK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strings = line.split(" ");
            int length = strings.length - 1;
            int[] nums = new int[length];
            for (int i = 0; i < length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(nums);
            int count = Integer.parseInt(strings[length]);
            for (int i = 0; i < count - 1; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println(nums[count - 1]);
        }
    }
}
