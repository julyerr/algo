package com.julyerr.leetcode.graph;

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs,
 * return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one0327 of them.
 * If it is impossible to finish all courses, return an empty array.
 */

//就是利用拓扑排序进行查找
public class CourseScheduleII {
    public int[] findOrder(int courseNum, int[][] prequisition) {
        int[] count = new int[courseNum];
//        没有任何先修课程，直接返回（有点坑）
        if (prequisition == null || prequisition.length == 0) {
            for (int i = 0; i < courseNum; i++) {
                count[i] = courseNum - 1 - i;
            }
            return count;
        }
        //        统计课程的先修数
        for (int i = 0; i < prequisition.length; i++) {
            count[prequisition[i][0]]++;
        }
        int[] ret = new int[courseNum];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
//        没有先修课程的课程加入队列
        for (int i = 0; i < courseNum; i++) {
            if (count[i] == 0) {
                queue.add(i);
                ret[index++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int finished = queue.poll();
            for (int i = 0; i < prequisition.length; i++) {
                if (prequisition[i][1] == finished) {
                    count[prequisition[i][0]]--;
                    if (count[prequisition[i][0]] == 0) {
//                        没有先修课程的课程加入队列
                        ret[index++] = prequisition[i][0];
                        queue.add(prequisition[i][0]);
                    }
                }
            }
        }
        if (index != courseNum) {
            return new int[]{};
        }
        return ret;
    }
}
