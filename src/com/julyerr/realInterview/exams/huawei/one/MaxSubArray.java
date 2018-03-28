package com.julyerr.realInterview.exams.huawei.one;

import java.util.Scanner;

public class MaxSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long cur = 0;
            long maxSum = 0;
            String line = scanner.nextLine();
            String[] strings = line.split(",");
            for (String str :
                    strings) {
//                int tmp = str.startsWith("-")?-1*Integer.parseInt(str.substring(1)):Integer.parseInt(str);
                long tmp = Long.parseLong(str.trim());
                cur = Math.max(cur+tmp,tmp);
                maxSum = Math.max(maxSum,cur);
            }
            System.out.println(maxSum);
        }
    }
}