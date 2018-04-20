package com.julyerr.pat.levelone.partone;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 使用递归的方式，超时;
 * 改用直接判断，java还是非常容易超时的。。。
 * */
public class PerfectSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int p = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            int maxLen = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + maxLen; j < N; j++) {
                    long a = nums[i];
                    long b = nums[j];
                    long sum = a * p;
                    if (b <= sum) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    } else {
                        break;
                    }
                }
            }
            System.out.println(maxLen);
        }
    }

//    递归的方式超时
    //    private static int dfs(int[] nums, int left, int right, int p) {
//        long a = nums[left];
//        long b = nums[right];
//        long c = nums[left] * p;
//        int size = right - left + 1;
//        if (b <= c) {
//            return size;
//        }
//        return Math.max(dfs(nums, left + 1, right, p),
//                dfs(nums, left, right - 1, p));
//    }
}
