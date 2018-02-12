package com.julyerr.targetOffer.dp;


/*
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * */


/**
 * 使用左右两个array,求解结果的时候直接array[left] * array[right]即可
 */
public class MultiOnly {
    public int[] multiply(int[] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        int length = A.length;
        int[] forward = new int[length];
        int[] backward = new int[length];
        int[] ret = new int[length];
        forward[0] = 1;
        backward[0] = 1;
        for (int i = 1; i < length; i++) {
            forward[i] = forward[i - 1] * A[i - 1];
            backward[i] = backward[i - 1] * A[length - i];
        }
        for (int i = 0; i < length; i++) {
            ret[i] = forward[i] * backward[length - 1 - i];
        }
        return ret;
    }

    public static void main(String[] args) {
        MultiOnly multiOnly = new MultiOnly();
        int[] nums = new int[]{1, 2, 3};
        int[] ret = multiOnly.multiply(nums);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
        System.out.println();
    }
}
