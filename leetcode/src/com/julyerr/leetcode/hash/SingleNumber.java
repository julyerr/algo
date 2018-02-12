package com.julyerr.leetcode.hash;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

/**
 *对于出现2次的数字，用异或。因为“相异为1”，所以一个数字异或本身为0，而0异或0仍为0， 一个数字异或0仍为这个数字。

 0 ^ 0 = 0
 n ^ 0 = n
 n ^ n = 0


 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int n = 0;
        for (int i :
                nums) {
            n ^= i;
        }
        return n;
    }
}
