package com.julyerr.realInterview.exams.xiaomi;

import java.util.Scanner;

public class Second {
    private static int caculate(int[] a) {
        if (a == null) return 0;
        int left = 0;
        int right = a.length - 1;
        int max_left = a[left];
        int max_right = a[right];
        int volume = 0;

        while (left < right) {
            if (max_left < max_right) {
                left++;
                if (max_left < a[left]) {
                    max_left = a[left];
                } else {
                    volume += max_left - a[left];
                }
            } else {
                right--;
                if (max_right < a[right]) {
                    max_right = a[right];
                } else {
                    volume += max_right - a[right];
                }
            }
        }
        return volume;
    }


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int findMaxCapacity(int[] array, int m) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] += m;
            max = Math.max(caculate(array), max);
            array[i] -= m;
        }
        return max;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _array_size = 0;
        _array_size = Integer.parseInt(in.nextLine().trim());
        int[] _array = new int[_array_size];
        int _array_item;
        for (int _array_i = 0; _array_i < _array_size; _array_i++) {
            _array_item = Integer.parseInt(in.nextLine().trim());
            _array[_array_i] = _array_item;
        }

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        res = findMaxCapacity(_array, _m);
        System.out.println(String.valueOf(res));

    }
}
