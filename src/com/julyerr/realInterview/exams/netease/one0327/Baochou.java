package com.julyerr.realInterview.exams.netease.one0327;

import java.util.*;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/discuss/70736?type=0&order=0&pos=15&page=1
 * 经过了两次map转换，先将能力值排序好之后映射成cnt（代表能力值从小到大排序之后的下标），然后cnt又映射成对应的收入（收入需要更新判断）
 * */
public class Baochou {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();


            int index = 0;
            int total = N + M;
            int[] hard1 = new int[N];
            int[] bonesses = new int[N];
            int[] hard2 = new int[M];
//            总的能力值
            int[] hards = new int[total];
            for (int i = 0; i < N; i++) {
                hard1[i] = scanner.nextInt();
                hards[index++] = hard1[i];
                bonesses[i] = scanner.nextInt();
            }

            for (int i = 0; i < M; i++) {
                hard2[i] = scanner.nextInt();
                hards[index++] = hard2[i];
            }
            Arrays.sort(hards);
            int cnt = 0;
//            能力值到cnt的映射
            Map<Integer, Integer> map = new HashMap<>();
            map.put(hards[0], cnt++);
            for (int i = 1; i < total; i++) {
                if (hards[i] != hards[i - 1]) {
                    map.put(hards[i], cnt++);
                }
            }
            int[] profit = new int[total];
//            能力值到收入的映射
            for (int i = 0; i < N; i++) {
                profit[map.get(hard1[i])] = Math.max(profit[map.get(hard1[i])], bonesses[i]);
            }
//            更新收入
            for (int i = 1; i < total; i++) {
                profit[i] = Math.max(profit[i], profit[i - 1]);
            }
//            直接映射输出
            for (int i = 0; i < M; i++) {
                System.out.println(profit[map.get(hard2[i])]);
            }
        }
    }
}