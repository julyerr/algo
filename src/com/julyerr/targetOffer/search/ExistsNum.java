package com.julyerr.targetOffer.search;

/**
 * 一个二维数组中，每一行从左到右递增，每一列从上到下递增。输入一个整数，判断数组中是否含有该整数
 */

/**
 * 原作者的思路比较巧妙，使用左下方为起始节点开始扫描,效率为log(n)
 * 自己使用的是二分法查找，效率log，如果矩阵比较大的话
 */

public class ExistsNum {
    public boolean isExists(int[][] nums, int elem) {
//        check validation
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return false;
        }
        int m = nums.length;
        int n = nums[0].length;
//        check the boundary
        if (elem < nums[0][0] || elem > nums[m - 1][n - 1]) {
            return false;
        }
        int length = m * n - 1, left, right;
        left = 0;
        right = length;
        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid / n][mid % n];
            if (num > elem) {
                right = mid - 1;
            } else if (num < elem) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isExits2(int[][] nums, int elem) {
        if (nums == null || nums.length == 0 || nums[0].length == 0) {
            return false;
        }
        int m = nums.length - 1;
        int n = nums[0].length - 1;
//        check the boundary
        if (elem < nums[0][0] || elem > nums[m][n]) {
            return false;
        }
        int curRow = m;
        int curCol = 0;
        while ((curRow >= 0 && curRow <= m) && (curCol >= 0 && curCol <= n)) {
            if (elem > nums[curRow][curCol]) {
                curCol++;
            } else if (elem < nums[curRow][curCol]) {
                curRow--;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
//                {1, 2, 3, 4},
//                {5, 6, 7, 9}
                {1,3}
        };
        ExistsNum existsNum = new ExistsNum();
//        System.out.println(existsNum.isExists(nums, 2));
//        System.out.println(existsNum.isExists(nums, 8));
//        System.out.println(existsNum.isExists(nums, 1));
//        System.out.println(existsNum.isExists(nums, 0));
//        System.out.println(existsNum.isExists(nums, 9));
        System.out.println(existsNum.isExists(nums, 2));
    }
}
