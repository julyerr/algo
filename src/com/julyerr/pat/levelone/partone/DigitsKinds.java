package com.julyerr.pat.levelone.partone;

import java.util.Arrays;
import java.util.Scanner;

public class DigitsKinds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int[] kinds = new int[5];
            boolean flag = true;
            int times = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                switch (nums[i] % 5) {
                    case 0:
                        if ((nums[i] & 1) == 0) {
                            kinds[0] += nums[i];
                        }
                        break;
                    case 1:
                        if (flag) {
                            kinds[1] += nums[i];
                        } else {
                            kinds[1] -= nums[i];
                        }
                        flag = !flag;
                        break;
                    case 2:
                        kinds[2]++;
                        break;
                    case 3:
                        kinds[3] += nums[i];
                        times++;
                        break;
                }
            }
            Arrays.sort(nums);
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] % 5 == 4) {
                    kinds[4] = nums[i];
                    break;
                }
            }
            if (kinds[0] != 0) {
                System.out.print(kinds[0]);
            } else {
                System.out.print("N");
            }
            for (int i = 1; i < 5; i++) {
                if (kinds[i] != 0) {
                    if (i == 3) {
                        System.out.printf(" %.1f", kinds[i] * 1.0 / times);
                    } else {
                        System.out.print(" " + kinds[i]);
                    }
                } else {
                    System.out.print(" N");
                }
            }
            System.out.println();
        }
    }
}
