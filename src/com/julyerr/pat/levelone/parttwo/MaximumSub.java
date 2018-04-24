package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

public class MaximumSub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            boolean neg = true;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                if (nums[i] >= 0) {
                    neg = false;
                }
            }
            if (neg) {
                System.out.println(0 + " " + nums[0] + " " + nums[n - 1]);
            } else {
                int start = 0;
                int end = 0;
                int max = nums[0];
                int cur = nums[0];
                int curStart = 0, curEnd = 0;
                for (int i = 1; i < n; i++) {
                    if (cur + nums[i] < nums[i]) {
                        cur = nums[i];
                        curStart = i;
                    } else {
                        cur += nums[i];
                    }
                    curEnd = i;

                    if (max < cur) {
                        max = cur;
                        start = curStart;
                        end = curEnd;
                    }
                }
                System.out.println(max + " " + nums[start] + " " + nums[end]);
            }
        }
    }
}
