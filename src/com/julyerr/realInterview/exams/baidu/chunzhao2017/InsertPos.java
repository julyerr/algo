package com.julyerr.realInterview.exams.baidu.chunzhao2017;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 可以考虑每次将未排序的最小值位置确定好，以例子说明：
 * [19,8,7,9,25]
 * 先使用map记录每个值的出现位置，19：0,8：1,7：2,9：3,25：4
 * 如果数组排列好为[7,8,9,19,25];
 * 7的下一个为8,对应位置为1,在7之前，需要移动到最后并更新位置为8：5;
 * 8的下一个9,对应位置3,在8之前，需要移动到最后并更新位置为9：6;
 * 9的下一个19,对因位置0,在9之前，需要移动到最后并更新位置为19：7；
 * ...
 * 具体参见代码
 * */
public class InsertPos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
//                记录相对位置
                nums[i] = scanner.nextInt();
                map.put(nums[i], i);
            }
//            数组排序好
            Arrays.sort(nums);
            int last = n;
            int ops = 0;
            for (int i = 0; i < n - 1; i++) {
//                出现位置之前，需要更新
                if (map.get(nums[i + 1]) < map.get(nums[i])) {
                    map.put(nums[i + 1], ++last);
                    ops++;
                }
            }
            System.out.println(ops);
        }
    }
}
