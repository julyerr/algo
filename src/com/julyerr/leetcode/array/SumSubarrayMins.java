package com.julyerr.leetcode.array;


public class SumSubarrayMins {
    public int sumSubarrayMins(int[] A) {
        int whole = 10 ^ 9 + 7;
        if (A == null || A.length < 1) {
            return 0;
        }
        int rt = 0;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            rt += A[i];
            rt %= whole;
        }
        while (index < A.length) {
            int count = 0;
            for (int i = 0; i < A.length - 1 - index; i++) {
                A[count++] = Math.min(A[i], A[i + 1]);
                rt += A[count - 1];
            }
            index++;
        }
        return rt;
    }

    public static void main(String[] args){
        int[] tmp = new int[]{3,1,2,4};
        System.out.println(new SumSubarrayMins().sumSubarrayMins(tmp));
    }
}
