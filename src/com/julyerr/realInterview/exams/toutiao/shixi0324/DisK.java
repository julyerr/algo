package com.julyerr.realInterview.exams.toutiao.shixi0324;


import java.util.Arrays;
import java.util.Scanner;

/*
 * 先排序，去重，使用两个游标差值为k
 * */
public class DisK {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            int index = 0;
            for (int i = 0; i < n; i++) {
                nums[index++] = nums[i];
                while (i + 1 < n && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
            int ret = 0;
            for (int i = 0; i < index - 1; i++) {
                for (int j = i + 1; j < index; j++) {
                    int tmp = nums[j] - nums[i];
                    if (tmp == k) {
                        ret++;
                    } else if (tmp > k) {
                        break;
                    }
                }
            }
            System.out.println(ret);
        }
    }
}
