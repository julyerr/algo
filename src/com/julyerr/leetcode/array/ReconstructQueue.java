package com.julyerr.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 参考解题思路：https://blog.csdn.net/qq_33487412/article/details/81839154
 * */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length < 1 || people[0] == null
                || people[0].length < 1) {
            return people;
        }
//        自定义排好序之后
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] >= tmp.size()) {
                tmp.add(people[i]);
            } else {
                tmp.add(people[i][1], people[i]);
            }
        }
        int[][] rt = new int[people.length][2];
        for (int i = 0; i < tmp.size(); i++) {
            rt[i] = tmp.get(i);
        }
        return rt;
    }
}
