package com.julyerr.realInterview.array;

/*
 * 这道题目关键是理解题目的意思，其中发车时间可以作为等车的参考
 * */
public class TakeBuses {
    public int chooseLine(int[] stops, int[] period, int[] interval, int n, int s) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
//            等待时间
            int waitStartTime = s % interval[i] == 0 ? 0 : (interval[i] - s % interval[i]);
//            在路上运行时间
            int runTime = (stops[i] + 1) * 5 + stops[i] * period[i];
            min = Math.min(min, runTime + waitStartTime);
        }
        return min + s;
    }
}
