package com.julyerr.realInterview.exams.netease.one0327;

import java.util.Arrays;
import java.util.Scanner;

public class Clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n =scanner.nextInt();
            timeStamp[] timeStamps = new timeStamp[n];
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                timeStamps[i] = new timeStamp(start,end);
            }
            int cost = scanner.nextInt();
            int start = scanner.nextInt();
            int end = scanner.nextInt();
//            最迟的出发时间
            if(end>=cost){
                end -= cost;
            }else{
                start--;
                end = 60+end-cost;
            }
//            闹钟时间从早到晚
            Arrays.sort(timeStamps);
            timeStamp classTime = new timeStamp(start,end);
            int i=0;
            for (i = n-1; i >=0; i--) {
//                小于即可返回
                if(timeStamps[i].compareTo(classTime)<=0){
                    System.out.println(timeStamps[i].start+" "+timeStamps[i].end);
                    break;
                }
            }
        }
    }

//    自定义排序
    private static class timeStamp implements Comparable<timeStamp>{
        public timeStamp(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start,end;

        @Override
        public int compareTo(timeStamp o) {
            if(o.start == this.start){
                return this.end-o.end;
            }
            return this.start-o.start;
        }
    }
}
