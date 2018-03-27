package com.julyerr.niuke.company.meituan;

import java.util.Scanner;

/*
* 也是leetcode上的一道原题，先不断向右拓展（如果数组递增的话），出现下降然后回溯求解最大值
* */
public class MaxRectange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long max = 0;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if(i+1<n&&nums[i]<=nums[i+1]){
                    continue;
                }
                int minHeight = nums[i];
                for (int j = i; j >=0; j--) {
                    minHeight = Math.min(minHeight,nums[j]);
                    max = Math.max(max,minHeight*(i-j+1));
                }
            }
            System.out.println(max);
        }
    }
}
