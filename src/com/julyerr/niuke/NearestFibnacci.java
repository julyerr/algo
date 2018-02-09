package com.julyerr.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 题目描述
Fibonacci数列是这样定义的：
F[0] = 0
F[1] = 1
for each i ≥ 2: F[i] = F[i-1] + F[i-2]
因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。
给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
输入描述:
输入为一个正整数N(1 ≤ N ≤ 1,000,000)
输出描述:
输出一个最小的步数变为Fibonacci数"
示例1
输入

15
输出

2
* */

/*
 * 使用list不断增加新的元素，然后取出最后一个数值进行大小比较
 * */
public class NearestFibnacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NearestFibnacci nearestFibnacci = new NearestFibnacci();
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(nearestFibnacci.smallestSteps(n));
        }
    }

    public int smallestSteps(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        int lastIndex = list.size() - 1;
        while (list.get(lastIndex) < n) {
            list.add(list.get(lastIndex) + list.get(lastIndex - 1));
            lastIndex++;
        }
        int t1 = Math.abs(list.get(lastIndex) - n);
        int t2 = Math.abs(list.get(lastIndex - 1) - n);
        if (t1 >= t2) {
            return t2;
        }
        return t1;
    }
}
