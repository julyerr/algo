package com.julyerr.pat.levelone.partone;

import java.util.Arrays;
import java.util.Scanner;

public class MergeInsert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            boolean isInsert = true;
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (i + 1 < n && nums[i] > nums[i + 1]) {
                    index = i + 1;
                    break;
                }
            }
            for (int i = n - 1; i >= index; i--) {
                if (nums[i] != tmp[i]) {
                    isInsert = false;
                    break;
                }
            }

            if (isInsert) {
                System.out.println("Insertion Sort");
                Arrays.sort(nums, 0, index + 1);
            } else {
//                想不到更好的方法只能进行模拟
                System.out.println("Merge Sort");
                int k = 2;
                while (true) {
                    boolean flag = true;
                    for (int i = 0; i < n; i++) {
                        if (nums[i] != tmp[i]) {
                            flag = false;
                            break;
                        }
                    }

                    for (int i = 0; i < n; i += k) {
                        int a = (i + k) >= n ? n : i + k;
                        Arrays.sort(tmp, i, a);
                    }
                    k = k << 1;
                    if (flag) {
                        break;
                    }
                }
                nums = tmp;
            }

            System.out.print(nums[0]);
            for (int i = 1; i < n; i++) {
                System.out.print(" " + nums[i]);
            }
            System.out.println();
        }
    }

}
