package com.julyerr.realInterview.exams.pingduoduo.shixi0403;

import java.util.Scanner;

public class Priority {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n =scanner.nextInt();
            int k = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                min = Math.min(min,nums[i]);
                max = Math.max(max,nums[i]);
            }
            System.out.print(max-min);
            for (int i = k; i < n; i++) {
                int tmp = nums[i-k];
                min = Math.min(min,nums[i]);
                max = Math.max(max,nums[i]);
                if(min == tmp){
                    min = Integer.MAX_VALUE;
                    for (int j = i-k+1; j <= i; j++) {
                        min = Math.min(min,nums[j]);
                    }
                }
                if(max == tmp){
                    max = Integer.MIN_VALUE;
                    for (int j = i-k+1; j <= i; j++) {
                        max = Math.max(max,nums[j]);
                    }
                }
                System.out.print(" "+(max-min));
            }
            System.out.println();
        }
    }
}
/*
8 3
1 3 -1 -3 5 3 6 7
* */