package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.*;

/*
 * 此题需要考虑从后往前遍历，可以使用map结构，针对不存在的情况才进行添加
 * */
public class RemoveDuplicateLast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int index = 0;
            for (int i = n - 1; i >= 0; i--) {
//                不出现的情况才添加进来
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], 1);
                    list.add(nums[i]);
                    index++;
                }
            }
            System.out.print(list.get(index - 1));
            for (int i = index - 2; i >= 0; i--) {
                System.out.print(" " + list.get(i));
            }
            System.out.println();
        }
    }
}
