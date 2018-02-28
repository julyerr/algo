package com.julyerr.leetcode.searchSort;

public class Search2D {
    public boolean searchMatrix(int[][] matrix, int target) {
//        check validation
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int xLen = matrix.length;
        int yLen = matrix[0].length;
//        边界条件检查
        if(target < matrix[0][0] || target > matrix[xLen-1][yLen-1]){
            return false;
        }

//        使用二分法查找
        int left = 0;
        int right = xLen * yLen-1;
        while (left <= right) {
            int mid = (left + right) >> 1;

//            对应的二维坐标
            int x = mid / yLen;
            int y = mid % yLen;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Search2D search2D = new Search2D();
        int[][] matrix = new int[][]{
//                {1,3}
                {1,1}
        };
        System.out.println(search2D.searchMatrix(matrix,2));
    }
}
