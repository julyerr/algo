package com.julyerr.realInterview.exams.tencent;

import java.util.ArrayList;
import java.util.List;

public class PrimPair {
    //    使用空间换时间的方法，素数筛选的方式过滤掉不是素数的字母，然后求和判断
    public List<List<Integer>> primPair(int n) {
        int[] nums = new int[1001];
        nums[1] = 1;
        for (int i = 2; i < 501; i++) {
            for (int j = 2; i * j < 1001; j++) {
                nums[i * j] = 1;
            }
        }

        List<List<Integer>> rt = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (nums[i] == 0 && nums[n - i] == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(n - i);
                rt.add(tmp);
            }
        }
        return rt;
    }

    //    直接根据素数判断
    private boolean isPrim(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int primPairTimes(int n) {
        int count = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (isPrim(i) && isPrim(n - i)) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        PrimPair primPair = new PrimPair();
        System.out.println(primPair.primPair(10));
    }
}
