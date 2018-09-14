package com.julyerr.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
* 参考丑数的解题思路
* */
public class NthSuperUglyNumber {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] count = new int[k];
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int min = primes[0];
        while (--n > 0) {
            min = list.get(count[0])*primes[0];
            for (int i = 1; i < k; i++) {
                min = Math.min(min,list.get(count[i])*primes[i]);
            }
            list.add(min);
            for (int i = 0; i < k; i++) {
                if(min == list.get(count[i])*primes[i]){
                    count[i]++;
                }
            }
        }
        return min;
    }

    public static void main(String[] args){
        int n = 12;
        int[] primes = new int[]{2,7,13,19};
        System.out.println(nthSuperUglyNumber(n,primes));
    }
}
