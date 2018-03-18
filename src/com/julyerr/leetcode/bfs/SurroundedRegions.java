package com.julyerr.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 参考大神的解题思路：http://blog.csdn.net/wzy_1988/article/details/44494807
 * 从边缘节点N出发，将所有N='O'而且相连的‘O'标记为'K'（使用广度遍历的方式）,最后将所有的'K'变成’O'
 * */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length < 2 || board[0] == null || board[0].length < 2) {
            return;
        }
        row = board.length;
        column = board[0].length;
//        第一行
        for (int i = 0; i < column; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
        }

//        最后一行
        for (int i = 0; i < column; i++) {
            if (board[row - 1][i] == 'O') {
                dfs(board, row - 1, i);
            }
        }

//        第一列
        for (int i = 1; i < row - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }

//        最后一列
        for (int i = 1; i < row - 1; i++) {
            if (board[i][column - 1] == 'O') {
                dfs(board, i, column - 1);
            }
        }

//        重新进行调整
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = (board[i][j] == 'K') ? 'O' : 'X';
            }
        }
    }

    Queue<Point> queue = new LinkedList<>();
    //    为节省代码长度，设置二维数组
    int[][] points = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    int row;
    int column;

    private void dfs(char[][] board, int x, int y) {
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            board[point.x][point.y] = 'K';
            for (int i = 0; i < 4; i++) {
                int tmpX = point.x + points[i][0];
                int tmpY = point.y + points[i][1];
//                将新的元素添加到队列
                if (tmpX >= 0 && tmpX < row && tmpY >= 0 && tmpY < column && board[tmpX][tmpY] == 'O') {
                    queue.add(new Point(tmpX, tmpY));
                }
            }
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
