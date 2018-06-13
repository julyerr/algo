package com.julyerr.leetcode.array;


/*
 * 解题思路：https://blog.csdn.net/qq508618087/article/details/50990076
 * 增量判断的思路，不能到达就改变起始位置
 * */
public class Circuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null) {
            return -1;
        }
        int cur = 0, start = 0, lack = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0) {
                start = i + 1;
                lack += cur;
                cur = 0;
            }
        }
        return cur + lack >= 0 ? start : -1;
    }
}
