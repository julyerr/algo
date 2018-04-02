package com.julyerr.realInterview.exams.netease.neitui2018;

import java.util.Arrays;
import java.util.Scanner;

public class DeltaK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            boolean flag = true;
            int delta = nums[1]-nums[0];
            for (int i = 2; i < n; i++) {
                if(nums[i]-nums[i-1]!=delta){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("Possible");
            }else{
                System.out.println("Impossible");
            }
        }
    }
}
