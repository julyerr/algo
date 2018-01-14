package com.julyerr.leetcode.sort;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * <p>
 * click to show follow up.
 * <p>
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * <p>
 * Could you come up with an one-pass algorithm using only constant space?
 */

/**
 * using the cursor at the two end
 */
public class SortColors {
    public void sortColors(int[] colors){
        if(colors==null || colors.length == 0){
            return;
        }
        int red = 0,blue = colors.length-1;
        for (int i = 0; i <= blue; i++) {
            if(colors[i] == 0){
                swap(colors,i,red++);
            }else if(colors[i] == 2){
                swap(colors,i--,blue--);
            }
        }
    }

    private void swap(int[] nums,int a,int b){
        int tmp = nums[b];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
