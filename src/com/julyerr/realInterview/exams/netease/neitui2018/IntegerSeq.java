package com.julyerr.realInterview.exams.netease.neitui2018;

import java.util.Scanner;

public class IntegerSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int mid = n / 2;
            int index = 0;
            if(n%2!=0){
                nums[mid] = scanner.nextInt();
                index++;
                for (int i = 0; i < mid; i++) {
                    nums[mid+index] = scanner.nextInt();
                    nums[mid-index] = scanner.nextInt();
                    index++;
                }
            }else{
                nums[mid] = scanner.nextInt();
                index++;
                for (int i = 0; i < mid-1; i++) {
                    nums[mid-index] = scanner.nextInt();
                    nums[mid+index] = scanner.nextInt();
                    index++;
                }
                nums[0] =scanner.nextInt();
            }
            System.out.print(nums[0]);
            for (int i = 1; i < n; i++) {
                System.out.print(" "+nums[i]);
            }
            System.out.println();
        }
    }
}
