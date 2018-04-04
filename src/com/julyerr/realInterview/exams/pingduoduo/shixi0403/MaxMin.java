package com.julyerr.realInterview.exams.pingduoduo.shixi0403;

import java.util.Scanner;

/*
考试的时候没有做出来，参考大神的解题思路：https://www.nowcoder.com/discuss/71951

建立一个数组，然后针对每个区间中的每个数字++操作，最后比较是否符合题目要求
* */
public class MaxMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] x1 = new int[n];
            int[] x2 = new int[n];
            int[] cnt = new int[101];
            for (int i = 0; i < n; i++) {
                x1[i] = scanner.nextInt();
                x2[i] = scanner.nextInt();
//                统计区间每个值出现次数
                for (int j = 50 + x1[i]; j <= 50 + x2[i]; j++) {
                    cnt[j]++;
                }
            }

            int min = 100;
            int max = -100;
//            从小到大
            for (int i = 0; i <= 100; i++) {
                if (cnt[i] >= k) {
                    min = i - 50;
                    break;
                }
            }
//            从大到小
            for (int i = 100; i >= 0; i--) {
                if (cnt[i] >= k) {
                    max = i - 50;
                    break;
                }
            }
            if (min == 100 || max == -100) {
                System.out.println("error");
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}
/*
4 2
0 1
1 3
2 4
3 5
* */