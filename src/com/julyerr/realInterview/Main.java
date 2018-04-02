package com.julyerr.realInterview;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int count = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            System.out.println(dfs(nums,count,0)?"perfect":"good");
        }
    }

    private static boolean dfs(int[] nums, int target, int start) {
        if (start > nums.length) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                continue;
            }
            if (dfs(nums, target - nums[i], i+1)) {
                return true;
            }
        }
        return false;
    }
}
/*

5 100
10 20 30 40 50

5 200
100 30 20 110 120
* */
