package com.julyerr.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle
 * which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * *Example: **19 is a happy number
 * <p>
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        while (true) {
            int tmp = help(n);
            if (tmp == 1) {
                return true;
            }
            if (!map.containsKey(tmp)) {
                map.put(tmp, 1);
                n = tmp;
            } else {
                break;
            }
        }
        return false;
    }

    private int help(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n = n / 10;
        }
        return sum;
    }
    public static void main(String[] args){
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
        System.out.println(happyNumber.isHappy(12));
    }
}
