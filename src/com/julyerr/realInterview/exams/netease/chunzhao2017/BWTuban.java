package com.julyerr.realInterview.exams.netease.chunzhao2017;

import java.util.Scanner;

/*
* 相对简单的贪心
* */
public class BWTuban {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
//                当前列，白色和黑色连续最大值
                int bCount = 0;
                int wCount = 0;
                for (int j = 0; j < n; j++) {
                    if(strings[j].charAt(i)=='B'){
                        int bTmp=1;
                        while(j+1<n&&strings[j+1].charAt(i)=='B'){
                            bTmp++;
                            j++;
                        }
//                        更新
                        bCount = Math.max(bCount,bTmp);
                    }
                    if(strings[j].charAt(i)=='W'){
                        int wTmp=1;
                        while(j+1<n&&strings[j+1].charAt(i)=='W'){
                            wTmp++;
                            j++;
                        }
                        wCount = Math.max(wCount,wTmp);
                    }
                }
//                更新
                max = Math.max(max,Math.max(bCount,wCount));
            }
            System.out.println(max);
        }
    }
}
