package com.julyerr.leetcode.graph;

import java.util.*;

/**
 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs,
 return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them.
 If it is impossible to finish all courses, return an empty array.

 */

//就是利用拓扑排序进行查找
public class CourseScheduleII {
    public int[] findOrder(int courseNum, int[][] prequisition) {
        int length = prequisition.length;
        int[] ins = new int[courseNum];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            ins[prequisition[i][0]]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < courseNum; i++) {
            if (ins[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
//            int tmp = queue.remove()方式相同，但是poll更加符合表面的含义
            int tmp = queue.poll();
            list.add(tmp);
            for (int i = 0; i < length; i++) {
                if (prequisition[i][1] == tmp) {
                    ins[prequisition[i][0]]--;
                    if (ins[prequisition[i][0]] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        if(list.isEmpty()){
            return null;
        }
        int[] ret = new int[courseNum];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
