package com.julyerr.realInterview.dfs;

import java.util.ArrayList;

public class HanoiII {
    private String[] dirs = new String[]{"left", "mid", "right"};

    public ArrayList<String> getSolution(int n) {
        return getsolution(n, 0, 1, 2);
    }

    private ArrayList<String> getsolution(int n, int left, int mid, int right) {
        ArrayList<String> rt = new ArrayList<>();
        if (n == 1) {
            rt.add("move from " + dirs[left] + " to " + dirs[right]);
            return rt;
        }
        rt.addAll(getsolution(n - 1, left, right, mid));
        rt.addAll(getsolution(1, left, mid, right));
        rt.addAll(getsolution(n - 1, mid, left, right));
        return rt;
    }

    public static void main(String[] args) {
        HanoiII hanoii = new HanoiII();
        System.out.println(hanoii.getSolution(3));
    }
}
