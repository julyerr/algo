package com.julyerr.realInterview.exams.liulishuo;

import java.util.Scanner;

public class First {
//    下面这种方式有错误，因为零钱在乎的是组合，不是顺序（动态递归在乎的是顺序）
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] tmp = new int[]{1, 5, 10, 20, 50};
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            int[] dp = new int[n + 1];
//            dp[0] = 1;
//            for (int i = 1; i <= n; i++) {
//                for (int j = 0; j < tmp.length; j++) {
//                    if(i >= tmp[j]){
//                        dp[i] += dp[i-tmp[j]];
//                    }else{
//                        break;
//                    }
//                }
//            }
//            System.out.println(dp[n]);
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tmp = new int[]{1, 5, 10, 20, 50};
        int n = scanner.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = tmp[i]; j <= n; j++) {
                dp[j] += dp[j - tmp[i]];
            }
        }
        System.out.println(dp[n]);
    }
}
