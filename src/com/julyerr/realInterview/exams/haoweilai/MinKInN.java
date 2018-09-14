package com.julyerr.realInterview.exams.haoweilai;

import java.util.Arrays;
import java.util.Scanner;

/*
3 9 6 8 -10 7 -11 19 30 12 23 5
* */
public class MinKInN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.nextLine();
            String[] inputs = line.split(" ");
            int k = Integer.parseInt(inputs[inputs.length-1]);
            int[] nums = new int[inputs.length-1];
            for (int i = 0; i < inputs.length-1; i++) {
                nums[i] = Integer.parseInt(inputs[i]);
            }
            sort(nums,0,nums.length-1,k-1);
            System.out.print(nums[0]);
            for (int i = 1; i < k; i++) {
                System.out.print(" "+nums[i]);
            }
            System.out.println();
        }
    }

    private static void sort(int[] nums,int left,int right,int k){
        if (left >= right) {
            return;
        }
//        设置左右的游标
        int start = left, end = right;
//        保存第一个元素的值
        int temp = nums[start];
        while (start < end) {
//            找到右边第一个值小的元素
            while (start < end && temp < nums[end]) {
                end--;
            }
//            交换
            if (start < end)
                nums[start++] = nums[end];
//            找到左边第一个值大的元素
            while (start < end && nums[start] < temp) {
                start++;
            }
//            交换
            if (start < end) {
                nums[end--] = nums[start];
            }
        }
        nums[start] = temp;
        if(start>=k){
            return;
        }
        sort(nums,start+1,right,k);
    }
}
