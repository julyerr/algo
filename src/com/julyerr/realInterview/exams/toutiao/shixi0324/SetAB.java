package com.julyerr.realInterview.exams.toutiao.shixi0324;

import java.util.*;

/*
 * 主要是添加元素的选择问题，
 * 需要先从集合A挑选小于平均值的元素e，添加到大于集合B平均值才满足条件；
 * 而且挑选元素需要从小到大
 * */
public class SetAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
//            保证元素的顺序
            SortedSet<Integer> setA = new TreeSet<>();
            SortedSet<Integer> setB = new TreeSet<>();
//            为计算平均值方便
            double sumA = 0;
            double sumB = 0;
            for (int i = 0; i < n; i++) {
                int tmp = scanner.nextInt();
                sumA += tmp;
                setA.add(tmp);
            }

            for (int i = 0; i < m; i++) {
                int tmp = scanner.nextInt();
                sumB += tmp;
                setB.add(tmp);
            }

            int count = 0;
//            设置A平均值大于B
            if (sumA / n < sumB / m) {
                double tmp = sumA;
                sumA = sumB;
                sumB = tmp;

                SortedSet<Integer> set = setA;
                setA = setB;
                setB = set;

                int t = n;
                n = m;
                m = t;
            }
            for (Integer from :
                    setA) {
//                大于B平均值，且不能包含
                if (from <= sumB / m || setB.contains(from)) {
                    continue;
                }
                if (from >= sumA / n) {
                    break;
                }
                sumA -= from;
                sumB += from;
                n--;
                m++;
                count++;
            }
            System.out.println(count);
        }
    }
}

