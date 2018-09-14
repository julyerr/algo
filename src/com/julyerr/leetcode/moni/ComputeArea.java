package com.julyerr.leetcode.moni;

public class ComputeArea {
    //    关键是重叠部分面积的计算，求解两个矩形交接部分
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int down = Math.max(B, F);
        int up = Math.min(D, H);
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        if (left < right && down < up) {
            return area - (right - left) * (up - down);
        }
        return area;
    }
}
