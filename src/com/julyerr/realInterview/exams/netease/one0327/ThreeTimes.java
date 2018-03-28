package com.julyerr.realInterview.exams.netease.one0327;

import java.util.Scanner;

/*
 * 找规律的题，每三个连续数字中间有两个能够被三整除
 * */
public class ThreeTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int length = r - l + 1;
            int cnt = length / 3 * 2;
//            如果剩余最右边一个元素
            if (length % 3 == 1) {
                if (r % 3 == 0 || r % 3 == 2) {
                    cnt++;
                }
//                如果剩余最右边的两个元素，以此判断
            } else if (length % 3 == 2) {
                if (r % 3 == 0 || r % 3 == 2) {
                    cnt++;
                }
                if ((r - 1) % 3 == 0 || (r - 1) % 3 == 2) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
