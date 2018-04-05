package com.julyerr.realInterview.exams.niuke.one.Before2017.one;

import java.util.Scanner;

/*
 * 没有做出来，想到了使用波峰和波谷的特点，但是没有考虑到波峰和波谷的间距需要大于1（仔细观察数组）
 * */
public class Segments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int count = 0;
            for (int i = 1; i < n - 1; i++) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1] || nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                    count++;
//                间距需要大于1
                    if (n - 3 != i) {
                        i++;
                    }
                }
            }
            System.out.println(count + 1);
        }
    }
}
/*
6
1 2 3 2 2 1

2
* */