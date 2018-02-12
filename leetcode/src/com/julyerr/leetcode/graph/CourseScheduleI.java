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
    public boolean canFinished(int courseNum, int[][] prequisition) {
        int length = prequisition.length;
        int[] ins = new int[courseNum];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            ins[prequisition[i][0]]++;
        }
        int index = 0;
        for (int i = 0; i < courseNum; i++) {
            if (ins[i] == 0) {
                index++;
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
//            int tmp = queue.remove()方式相同，但是poll更加符合表面的含义
            int tmp = queue.poll();
            for (int i = 0; i < length; i++) {
                if (prequisition[i][1] == tmp) {
                    ins[prequisition[i][0]]--;
                    if (ins[prequisition[i][0]] == 0) {
                        index++;
                        queue.add(i);
                    }
                }
            }
        }
        return index == courseNum;
    }
}
