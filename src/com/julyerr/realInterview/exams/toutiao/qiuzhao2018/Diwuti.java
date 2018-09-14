package com.julyerr.realInterview.exams.toutiao.qiuzhao2018;

import java.util.Scanner;
import java.util.TreeMap;
/*
3
10
0 3 7 0 3 7
 */

public class Diwuti {
    //贪心，始终找最早结束的主播
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer, Integer>();
        int minStart = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if(start > end){
                end = m+end;
            }
            if(treeMap.get(end) != null){
                if(treeMap.get(end) < start){
                    treeMap.put(end,start);
                }
                if(minStart > start) minStart = start;
            }else{
                treeMap.put(end,start);
                if(minStart > start) minStart = start;
            }
        }
//        重新调整minStart 从零开始
        if(minStart > 0 ){
            TreeMap<Integer,Integer> tmp = new TreeMap<Integer, Integer>();
            for (Integer endTime :
                    treeMap.keySet()) {
                Integer startTime = treeMap.get(endTime);
                startTime = startTime - minStart;
                if(endTime - minStart > m){
                    endTime = m;
                }else{
                    endTime = endTime - minStart;
                }
                tmp.put(endTime,startTime);
            }
            treeMap = tmp;
        }


        int sum = 0;
        int lastEnd = 0;
        for (Integer endTime :
                treeMap.keySet()) {
            if(lastEnd <= endTime && treeMap.get(endTime) >=lastEnd){
                sum ++;
                lastEnd = endTime;
            }
        }
        System.out.println(sum);
    }
}