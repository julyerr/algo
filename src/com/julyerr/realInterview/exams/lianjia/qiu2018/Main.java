package com.julyerr.realInterview.exams.lianjia.qiu2018;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret += nums[i];
        }
        System.out.println(ret);
    }
}
