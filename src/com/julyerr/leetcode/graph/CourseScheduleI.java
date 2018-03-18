package com.julyerr.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * For example:
 * <p>
 * 2, [[1,0]]
 * <p>
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * <p>
 * 2, [[1,0],[0,1]]
 * <p>
 * There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
 * So it is impossible.
 */

//就是利用拓扑排序进行查找
public class CourseScheduleI {
    public boolean canFinish(int courseNum, int[][] prequisition) {
        if (prequisition == null || prequisition.length == 0 || prequisition[0] == null || prequisition[0].length < 2) {
            return true;
        }
        int[] count = new int[courseNum];
//        统计课程的先修数
        for (int i = 0; i < prequisition.length; i++) {
            count[prequisition[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
//        没有先修课程的课程加入队列
        for (int i = 0; i < courseNum; i++) {
            if (count[i] == 0) {
                queue.add(i);
            }
        }
        int finishedCourse = queue.size();
        while (!queue.isEmpty()) {
            int finished = queue.poll();
            for (int i = 0; i < prequisition.length; i++) {
                if (prequisition[i][1] == finished) {
                    count[prequisition[i][0]]--;
                    if (count[prequisition[i][0]] == 0) {
//                        没有先修课程的课程加入队列
                        finishedCourse++;
                        queue.add(prequisition[i][0]);
                    }
                }
            }
        }
        return finishedCourse == courseNum;
    }
}
