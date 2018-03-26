package com.julyerr.realInterview.array;

import java.util.Scanner;

/*
 * 解题思路：
 * 原地计算出两两相邻元素的差值，然后返回最大差值和nums[i]+nums[i+1]中较小值，下面以实际的例子为例：
 *
 * nums = -3,0,3,7,8
 * 两两之间的差值：interval = 3,3,4,1;最大差值为4
 * 每次去除一个元素，相当于interval中相邻元素合并，
 * 然后只需要迭代比较minVal = min(minVal,max(（interval[i]+interval[i+1]）,4))
 * 合并过程，如果interval[i]包含4的话，较大的肯定是interval[i]+interval[i+1]；
 * 如果不包含4，就需要比较max(interval[i]+interval[i+1],4)大小
 * */
public class MaxInterval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            int max = Integer.MIN_VALUE;
//            计算相邻差值，并且保留最大差值
            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i] - nums[i - 1];
                max = Math.max(max, nums[i]);
            }

            int min = Integer.MAX_VALUE;
//            返回两两合并之后差值的最小值
            for (int i = 1; i < n - 1; i++) {
                min = Math.min(min, Math.max(nums[i] + nums[i + 1], max));
            }
            System.out.println(min);
        }
    }
}
