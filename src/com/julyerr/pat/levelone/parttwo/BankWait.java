package com.julyerr.pat.levelone.parttwo;

import java.util.*;

/*
 * 总感觉思路没有错误，但是测试用例（数量太大，不可能直接对照）通不过;
 * 做题主要是为了锻炼思维，没有必要花时间在死角上，劳心费神哈
 * */
public class BankWait {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int K = scanner.nextInt();
            int Q = scanner.nextInt();
            List<Queue<Integer>> windows = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                windows.add(new LinkedList<>());
            }
            int[] leaveT = new int[K];
            int[] processT = new int[K];
            int[] pre = new int[N];
            for (int i = 0; i < K; i++) {
                processT[i] = scanner.nextInt();
            }
            List<Integer> query = new ArrayList<>();
            for (int i = 0; i < Q; i++) {
                query.add(scanner.nextInt());
            }


//            先将人数填充满
            int firstT = N * M >= K ? K : N * M;
            int tmp = 0;
            for (int i = 0; i < firstT; i++) {
                pre[tmp] += processT[i];
                leaveT[i] = pre[tmp];
                windows.get(tmp).add(leaveT[i]);
                tmp++;
                if (tmp >= N) {
                    tmp = 0;
                }
            }
            for (int i = firstT; i < K; i++) {
                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int j = 0; j < N; j++) {
                    if (min > windows.get(j).peek()) {
                        min = windows.get(j).peek();
                        minIndex = j;
                    }
                }
                windows.get(minIndex).poll();
                pre[minIndex] += processT[i];
                leaveT[i] = pre[minIndex];
                windows.get(minIndex).add(pre[minIndex]);
            }

            for (int i = 0; i < query.size(); i++) {
                int cur = leaveT[query.get(i) - 1];
                if (cur > 540) {
                    System.out.println("Sorry");
                } else {
                    System.out.printf("%02d:%02d\n", cur / 60 + 8, cur % 60);
                }
            }
        }
    }
}
