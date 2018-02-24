package com.julyerr.leetcode.array;

public class GameOfLife {
    static int n, m;

    public void gameOfLife(int[][] board) {
//        check validation
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        n = board.length - 1;
        m = board[0].length - 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int nums = calc(board, i, j);
                if (board[i][j] == 0) {
                    if (nums == 3) {
                        board[i][j] += 10;
                    }
                } else {
                    if (nums == 2 || nums == 3) {
                        board[i][j] += 10;
                    }
                }
            }
        }
//        更新+10
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                board[i][j] /= 10;
            }
        }
    }

    //    返回(x,y)四周的存活的cell个数
    private static int calc(int[][] board, int x, int y) {
        int ret = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
//                check boundary & not be itself
                if (i < 0 || j < 0 || i > n || j > m || (i == x && j == y)) {
                    continue;
                }
                if (board[i][j] % 10 == 1) {
                    ret++;
                }
            }
        }
        return ret;
    }
}

