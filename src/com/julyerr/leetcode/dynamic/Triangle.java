package com.julyerr.leetcode.dynamic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return 0;
        }
//        设置前后两个数组保持层次顺序
        int[] pre = new int[]{triangle.get(0).get(0)};
        int min = pre[0];

        for (int i = 1; i < triangle.size(); i++) {
            int[] cur = new int[i + 1];
            List<Integer> tmp = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                int val = tmp.get(j);
//                边缘情况直接复制元素下来相加即可
                if (j == 0) {
                    cur[j] = val + pre[j];
                    min = cur[j];
                } else if (j == i) {
                    cur[j] = val + pre[j-1];
//                    取上层元素的最小值
                } else {
                    cur[j] = Math.min(pre[j], pre[j - 1]) + val;
                }
                if (min > cur[j]) {
                    min = cur[j];
                }
            }
//            交替迭代
            pre = cur;
        }
        return min;
    }

    public static void main(String[] args){
        Triangle triangle = new Triangle();
        Integer[][] integers = new Integer[][]{
                {-1},
                {-2,-3},
        };
        List<List<Integer>> rt = new ArrayList<>();
        for (int i = 0; i < integers.length; i++) {
            rt.add(Arrays.asList(integers[i]));
        }
        System.out.println(triangle.minimumTotal(rt));
    }
}
