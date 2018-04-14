package com.julyerr.realInterview.exams.niuke.one.One2017;

import java.util.Scanner;

/*
 * 提高暴力求解的速度
 * */
public class ManyFishes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int min = scanner.nextInt();
            int max = scanner.nextInt();

            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int ret = 0;
            for (int i = min; i <= max; i++) {
                for (int j = 0; j < nums.length; j++) {
//                    尽量不使用除的方法，而是改用乘的方法
                    if (nums[j] * 2 <= i && nums[j] * 10 >= i || nums[j] >= 2 * i && nums[j] <= 10 * i) {
                        ret++;
                        break;
                    }
                }
            }
            System.out.println(max - min + 1 - ret);
        }
    }

}
/*
1 36
1
3

10
* */