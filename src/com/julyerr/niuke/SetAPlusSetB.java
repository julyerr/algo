package com.julyerr.niuke;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/*
 * 直接使用java集合框架中提供的集合操作函数即可
 * */
public class SetAPlusSetB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            for (int i = 0; i < n; i++) {
                setA.add(scanner.nextInt());
            }

            for (int i = 0; i < m; i++) {
                setB.add(scanner.nextInt());
            }
//            集合合并
            setA.addAll(setB);
            Integer[] ts = new Integer[setA.size()];
//            排序
            setA.toArray(ts);
            Arrays.sort(ts);
            for (int i = 0; i < ts.length - 1; i++) {
                System.out.print(ts[i] + " ");
            }
            System.out.println(ts[ts.length - 1]);
        }
    }
}
