package com.julyerr.realInterview.exams.kuaishou.chuzhao2018;

import java.util.Scanner;

public class BST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.nextLine();
            int x = scanner.nextInt();
            String[] strings = first.split(" ");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            if (x <= nums[0]) {
                System.out.println(0);
            } else if (x > nums[nums.length - 1]) {
                System.out.println(nums.length);
            } else {
//                int left = 0;
//                int right = nums.length - 1;
//                boolean find = false;
//                int mid;
//                while (left < right) {
//                    mid = (left + right) >> 1;
//                    if (nums[mid] > x) {
//                        right = mid - 1;
//                    } else if (nums[mid] < x) {
//                        left = mid + 1;
//                    } else {
//                        System.out.println(mid);
//                        find = true;
//                        break;
//                    }
//                }
//                if (!find) {
//                    System.out.println(left + 1);
//                }

                for (int i = 0; i < nums.length - 1; i++) {
                    if (nums[i] == x) {
                        System.out.println(i);
                        break;
                    } else if (nums[i + 1] == x) {
                        System.out.println(i + 1);
                        break;
                    } else if (x > nums[i] && x < nums[i + 1]) {
                        System.out.println(i + 1);
                        break;
                    }
                }
            }
        }
    }
}
