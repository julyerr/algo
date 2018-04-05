package com.julyerr.realInterview.exams.niuke.one.Before2017.one;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 先将数组排序好，要保证每一组中第二大值最大，那么尽可能先将第二大值往后移动
 * 例如：1,1,1,5,8,8,8,9,9分成三组，
 * 要使第二大最大，那么{1,5,8}，{1,8,8}，{1,9,9}便为结果
 * 5,8,8,8,9,9,这些数字都需要被用到，每两个作为第二大和第一大值归为一组，可以使后面组第二大值尽可能取到最大
 * */
public class HighAveLevel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n * 3];
            for (int i = 0; i < 3 * n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            long sum = 0;
//            将最大值尽可能往后移动
            for (int i = n; i < nums.length; i += 2) {
                sum += nums[i];
            }
            System.out.println(sum);
        }
    }
}
