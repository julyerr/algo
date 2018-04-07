package com.julyerr.realInterview.exams.netease.qiuzhao2017;

import java.util.Scanner;

public class BuyApple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
//            预先购买的8的袋子数
            int EightNum = n / 8;
            int remain = n % 8;
            if (remain == 0) {
                System.out.println(EightNum);
            } else {
                int count = 0;
//                通过观察发现，8少购买一袋，6就可以多增加2（余数）
//                如果8少购买了3袋，还是6还是不能整除，说明一定不能被6整除，直接跳出
                while (count < 3) {
                    if (remain % 6 == 0) {
                        break;
                    }
                    EightNum--;
//                    6增加的数
                    remain += 8;
                    count++;
                }
                if (count >= 3) {
                    System.out.println(-1);
                } else {
                    System.out.println(EightNum + remain / 6);
                }
            }
        }
    }
}
