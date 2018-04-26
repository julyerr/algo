package com.julyerr.pat.levelone.parttwo;

import java.util.*;

/*
 * 整体来说，感觉思路正确但是运行的时候报错，后面调调
 * */
public class BestRank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = new char[]{
                ' ', 'A', 'C', 'M', 'E'
        };
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Map<String, Stu> map = new HashMap<>();
            Stu[] stus = new Stu[n];
            for (int i = 0; i < n; i++) {
                String name = scanner.next();
                int c = scanner.nextInt();
                int math = scanner.nextInt();
                int e = scanner.nextInt();
                double ave = (c + math + e) * 1.0 / 3;
                stus[i] = new Stu(name, c, math, e, ave);
                map.put(name, stus[i]);
            }

            Stu.index = 1;
            Arrays.sort(stus);
            int count = 1;
            stus[0].aL = 1;
            for (int i = 1; i < n; i++) {
                if (Math.abs(stus[i - 1].aL - stus[i].aL) > 1e-7) {
                    count++;
                }
                stus[i].aL = count;
            }

            Stu.index = 2;
            Arrays.sort(stus);
            count = 1;
            stus[0].cL = 1;
            for (int i = 1; i < n; i++) {
                if (stus[i - 1].c != stus[i].c) {
                    count++;
                }
                stus[i].cL = count;
            }

            Stu.index = 3;
            Arrays.sort(stus);
            count = 1;
            stus[0].mL = 1;
            for (int i = 1; i < n; i++) {
                if (stus[i - 1].m != stus[i].m) {
                    count++;
                }
                stus[i].mL = count;
            }

            Stu.index = 4;
            Arrays.sort(stus);
            count = 1;
            stus[0].eL = 1;
            for (int i = 1; i < n; i++) {
                if (stus[i - 1].e != stus[i].e) {
                    count++;
                }
                stus[i].eL = count;
            }

            for (int i = 0; i < m; i++) {
                String name = scanner.next();
                if (!map.containsKey(name)) {
                    System.out.println("N/A");
                } else {
                    Stu stu = map.get(name);
                    int min = 100000;
                    int minIndex = -1;
                    if (min > stu.aL) {
                        min = stu.aL;
                        minIndex = 1;
                    }
                    if (min > stu.cL) {
                        min = stu.cL;
                        minIndex = 2;
                    }
                    if (min > stu.mL) {
                        min = stu.mL;
                        minIndex = 3;
                    }
                    if (min > stu.eL) {
                        min = stu.eL;
                        minIndex = 4;
                    }
                    System.out.println(min + " " + chars[minIndex]);
                }
            }
        }
    }

    private static class Stu implements Comparable<Stu> {
        private static int index = 1;
        String name;
        int c, m, e;
        Double ave;

        public Stu(String name, int c, int m, int e, double ave) {
            this.name = name;
            this.c = c;
            this.m = m;
            this.e = e;
            this.ave = ave;
        }

        @Override
        public int compareTo(Stu o) {
            if (index == 1) {
                return o.ave.compareTo(this.ave);
            } else if (index == 2) {
                return o.c - this.c;
            } else if (index == 3) {
                return o.m - this.m;
            }
            return o.e - this.e;
        }

        int aL, cL, mL, eL;
    }
}
