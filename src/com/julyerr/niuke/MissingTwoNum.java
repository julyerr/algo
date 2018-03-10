package com.julyerr.niuke;

import java.util.Arrays;
import java.util.Scanner;

//顺序被打乱
public class MissingTwoNum {
//    自己代码太low
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int[] nums = new int[9997];
//            int[] tmps = new int[3];
//            int index = 0;
//            for (int i = 0; i < 9997; i++) {
//                nums[i] = scanner.nextInt();
//            }
////            排序好
//            Arrays.sort(nums);
//            for (int i = 1; i < 9997; i++) {
//                int tmp = nums[i] - nums[i - 1];
//                if (tmp != 1) {
//                    if (tmp == 2) {
//                        tmps[index++] = nums[i] - 1;
//                    } else if (tmp == 3) {
//                        tmps[index++] = nums[i] - 2;
//                        tmps[index++] = nums[i] - 1;
//                    } else {
//                        tmps[index++] = nums[i] - 3;
//                        tmps[index++] = nums[i] - 2;
//                        tmps[index++] = nums[i] - 1;
//                    }
//                    if (index == 3) {
//                        break;
//                    }
//                }
//            }
//            System.out.println(Long.parseLong("" + nums[0] + nums[1] + nums[2]) % 7);
//        }
//    }

    //    参考大神的思路
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] nums = new int[10001];
            for (int i = 1; i <= 9997; i++) {
                int tmp = scanner.nextInt();
                nums[tmp] = i;
            }

            int count = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < 10001; i++) {
                if (nums[i] == 0) {
                    stringBuilder.append(i);
                    count++;
                    if (count == 3) {
                        break;
                    }
                }
            }
            System.out.println(Long.parseLong(stringBuilder.toString()) % 7);

        }
    }
}
