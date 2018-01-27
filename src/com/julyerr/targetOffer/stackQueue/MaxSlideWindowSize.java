package com.julyerr.targetOffer.stackQueue;

import java.util.*;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

public class MaxSlideWindowSize {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
//        check validation
        ArrayList<Integer> rt = new ArrayList<Integer>();
//        从测试结果来看，应该是size > num.length的情况就自动忽略
        if (num == null || num.length == 0 || size <= 0 || size > num.length) {
            return rt;
        }
        int max = num[0];
//        construct queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            queue.add(num[i]);
            max = Math.max(max, num[i]);
        }
        rt.add(max);
        for (int i = size; i < num.length; i++) {
            int tmp = queue.poll();
            queue.add(num[i]);
            max = Math.max(max, num[i]);
            if (tmp == max) {
                max = queue.peek();
                for (Integer integer :
                        queue) {
                    max = Math.max(max, integer);
                }
            }

            rt.add(max);
        }
        return rt;
    }

    public static void main(String[] args) {
        MaxSlideWindowSize maxSlideWindowSize = new MaxSlideWindowSize();
        int[] nums = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int windowSize = 3;
//        int[] nums = new int[]{1,1,1,1,1};
//        int windowSize = 1;
        List<Integer> list = maxSlideWindowSize.maxInWindows(nums, windowSize);
        for (Integer integer :
                list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
