package com.julyerr.realInterview.exams.xiechen0329;

import java.util.Scanner;

public class MoveZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n =scanner.nextInt();
            int[] nums = new int[n];
            int index = 0;
            for (int i = 0; i < n; i++) {
                int tmp = scanner.nextInt();
                if(tmp !=0){
                    nums[index++] = tmp;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(nums[i]);
            }
        }
    }
}
