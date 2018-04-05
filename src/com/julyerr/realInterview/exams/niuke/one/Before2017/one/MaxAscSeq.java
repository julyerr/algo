package com.julyerr.realInterview.exams.niuke.one.Before2017.one;

import java.util.Scanner;

/*
 * 参考大神的解题思路：http://www.cnblogs.com/olivegyr/p/6984519.html
 * 设置left，right两个数组,left[i]表示以i为结束的最长连续递增子串的长度,right[i]表示以i开始的最长连续递增子串的长度；
 * 然后针对i~n-1,如果nums[i-1]<nums[i+1],则取left[i-1]+right[i+1]的最大值
 * */
public class MaxAscSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            int[] left = new int[n];
            int[] right = new int[n];
            left[0] = 1;
//            计算left
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            }

//            计算right
            right[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    right[i] = right[i + 1] + 1;
                } else {
                    right[i] = 1;
                }
            }

            int maxLen = 1;
//            求解结果
            for (int i = 1; i < n - 1; i++) {
                if (nums[i - 1] < nums[i + 1] && maxLen < left[i - 1] + right[i + 1]) {
                    maxLen = left[i - 1] + right[i + 1];
                }
            }
//            添加上中间值
            System.out.println(maxLen + 1);
        }
    }
}
