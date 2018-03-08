package com.julyerr.niuke;

import java.util.Arrays;
import java.util.Scanner;


/*
*
* 解题思路：
* 先对输入的数据进行排序，然后按照差值小于10的三个元素三个元素组成一组，不足的话添加元素补充
* */
/*
* 4
20 35 23 40

5
20 20 35 23 40

6
20 20 35 23 40 70
* */

public class NumsOfProblems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(numsOfProblems(nums));
        }
    }

    private static int numsOfProblems(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 2) {
            return 2;
        }
        int index = 0;
//        ret代表连续3个的组数
        int ret = 0;
        while (index < length) {
            int count = 0;
            while (index + 1 < length && nums[index + 1] - nums[index] <= 10) {
                index++;
                count++;
//                3个元素已经构成了一组，跳出循环
                if (count == 2) {
                    break;
                }
            }
            ret++;
            index++;
        }
//        返回理论和实际的长度差值
        return 3 * ret - length;
    }
}
