package com.julyerr.leetcode.hash;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.

 According to the definition of h-index on Wikipedia: "A scientist has index h
 if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

 For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total
 and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

 Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */

public class HIndexI {
    public int hIndex(int[] citations) {
//        check validation
        if(citations == null || citations.length ==0){
            return 0;
        }
        int length = citations.length;
        Integer[] integers = new Integer[length];
        for (int i = 0; i < length; i++) {
            integers[i] = new Integer(citations[i]);
        }
        myComparator cmp = new myComparator();
        Arrays.sort(integers,cmp);
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(integers[i] >= i+1){
                count++;
            }else{
                break;
            }
        }
        return count;


    }
    class myComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    public static void main(String[] args){
        int[] citations = new int[]{3, 0, 6, 1, 5};
        HIndexI hIndexI = new HIndexI();
        System.out.println(hIndexI.hIndex(citations));
    }
}
