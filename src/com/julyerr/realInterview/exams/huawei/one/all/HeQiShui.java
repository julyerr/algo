package com.julyerr.realInterview.exams.huawei.one.all;

import java.util.Scanner;

public class HeQiShui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            if (count == 0) {
                break;
            }
            int sum = 0;
            while (count >= 3) {
                int tmp = count / 3;
                sum += tmp;
                tmp += count % 3;
                count = tmp;
            }
            if(count ==2){
                sum++;
            }
            System.out.println(sum);
        }
    }
}
