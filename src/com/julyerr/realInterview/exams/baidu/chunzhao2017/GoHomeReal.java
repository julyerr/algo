package com.julyerr.realInterview.exams.baidu.chunzhao2017;

import java.util.Scanner;

/*
 * 只需要求解出中间不经过某个点得到最大的缩短路径，然后总路径减去即可
 * */
public class GoHomeReal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            nums[0] = scanner.nextInt();
            nums[1] = scanner.nextInt();
            int max = Integer.MIN_VALUE;
            int pre = Math.abs(nums[1] - nums[0]);
//            总路径
            int sum = pre;
            int cur, all;
            for (int i = 2; i < n; i++) {
                nums[i] = scanner.nextInt();
                cur = Math.abs(nums[i] - nums[i - 1]);
                all = Math.abs(nums[i] - nums[i - 2]);
//                缩短路径的最大值
                max = Math.max(max, Math.abs(pre + cur - all));
                sum += cur;
                pre = cur;
            }
            System.out.println(sum - max);
        }
    }
}
/*
4
1 4 -1 3
4

4
100 -100 99 -99
199
* */