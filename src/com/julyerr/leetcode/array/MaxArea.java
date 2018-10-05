package com.julyerr.leetcode.array;

/*
 * 参考解题思路：https://blog.csdn.net/wzy_1988/article/details/17248209
 * https://blog.csdn.net/qq_16583687/article/details/76735989
 * */
public class MaxArea {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int rt = 0;
        while (i < j) {
            int tmp = Math.min(height[i], height[j]) * (j - i);
            rt = Math.max(tmp, rt);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return rt;
    }
}
