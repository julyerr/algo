package com.julyerr.pat.levelone.parttwo;

import java.util.Arrays;
import java.util.Scanner;

/*
 * java速度慢，部分测试数据超时
 * */
public class FileSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int c = scanner.nextInt();
            Stu.col = c;
            Stu[] stus = new Stu[n];
            for (int i = 0; i < n; i++) {
                stus[i] = new Stu(scanner.nextInt(), scanner.next(), scanner.nextInt());
            }
            Arrays.sort(stus);
            for (int i = 0; i < n; i++) {
                System.out.printf("%06d %s %d\n", stus[i].id, stus[i].name, stus[i].grade);
            }
        }
    }

    private static class Stu implements Comparable<Stu> {
        private static int col = 0;

        int id;
        String name;
        int grade;

        public Stu(int id, String name, int grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
        }

        @Override
        public int compareTo(Stu o) {
            if (col == 1) {
                return this.id - o.id;
            } else if (col == 2) {
                int tmp = this.name.compareTo(o.name);
                if (tmp == 0) {
                    return this.id - o.id;
                }
                return tmp;
            }
            if (this.grade == o.grade) {
                return this.id - o.id;
            }
            return this.grade - o.grade;
        }
    }
}
