package com.julyerr.realInterview.exams.pingduoduo.shixi0403;

import java.util.Scanner;

public class ShifenZhen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String time = scanner.next();
            String[] strs = time.split(":");
            int hour = Integer.parseInt(strs[0]) % 12;
            int minute = Integer.parseInt(strs[1]);
//            如果能够整除的话，输出整数
            if (minute * 30 % 60 == 0) {
                int hourD = hour * 30 + minute * 30 / 60;
                int minuteD = minute * 6;
                int tmp = Math.abs(hourD - minuteD);
                tmp = tmp > 180 ? 360 - tmp : tmp;
                System.out.println(tmp);
//                double类型计算
            } else {
                double hourD = hour * 30 + minute * 30.0 / 60;
                int minuteD = minute * 6;
                if (hourD > minuteD) {
                    hourD -= minuteD;
                } else {
                    hourD = minuteD - hourD;
                }
                hourD = hourD > 180.0 ? 360.0 - hourD : hourD;
                System.out.printf("%.1f\n", hourD);
            }
        }
    }
}
