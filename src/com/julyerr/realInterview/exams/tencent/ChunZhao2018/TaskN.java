package com.julyerr.realInterview.exams.tencent.ChunZhao2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TaskN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Machine[] machines = new Machine[n];
            Task[] tasks = new Task[m];
            for (int i = 0; i < n; i++) {
                int time = scanner.nextInt();
                int level = scanner.nextInt();
                machines[i] = new Machine(time, level);
            }

            for (int i = 0; i < m; i++) {
                int time = scanner.nextInt();
                int level = scanner.nextInt();
                tasks[i] = new Task(time, level, 200 * time + 3 * level);
            }

//            Arrays.sort(tasks, new Comparator<Task>() {
//                @Override
//                public int compare(Task o1, Task o2) {
//                    return o2.profit - o1.profit;
//                }
//            });
//
//            Arrays.sort(machines, new Comparator<Machine>() {
//                @Override
//                public int compare(Machine o1, Machine o2) {
//                    int tmp = o2.n - o1.n;
//                    if (tmp == 0) {
//                        return o2.m - o1.m;
//                    }
//                    return tmp;
//                }
//            });
//
//            int count = 0;
//            long profit = 0;
//            boolean[] visited = new boolean[n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (!visited[j] && tasks[i].n <= machines[j].n && tasks[i].m <= machines[j].m) {
//                        visited[j] = true;
//                        count++;
//                        profit += tasks[i].profit;
//                        break;
//                    }
//                }
//            }
            Arrays.sort(tasks, new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    int tmp = o2.n - o1.n;
                    if (tmp == 0) {
                        return o2.m - o1.m;
                    }
                    return tmp;
                }
            });

            Arrays.sort(machines, new Comparator<Machine>() {
                @Override
                public int compare(Machine o1, Machine o2) {
                    int tmp = o1.n - o2.n;
                    if (tmp == 0) {
                        return o1.m - o2.m;
                    }
                    return tmp;
                }
            });

            int count = 0;
            long profit = 0;
            boolean[] visited = new boolean[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[j] && tasks[j].n <= machines[i].n && tasks[j].m <= machines[i].m) {
                        visited[j] = true;
                        count++;
                        profit += tasks[j].profit;
                        break;
                    }
                }
            }
            System.out.println(count + " " + profit);
        }
    }

    private static class Task {
        int m, n, profit;

        public Task(int m, int n, int profit) {
            this.m = m;
            this.n = n;
            this.profit = profit;
        }
    }

    private static class Machine {
        int m, n;

        public Machine(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }
}

/*
1 2
100 3
100 2
100 1
* */