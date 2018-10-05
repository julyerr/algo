package com.julyerr.leetcode.array;

public class CountBattleships {
    public int countBattleships(char[][] board) {
        if (board == null || board.length < 1 || board[0] == null || board[0].length < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
//                    只有左侧和上侧不是'X'的时候才添加进来
                    if (i > 0 && board[i - 1][j] == 'X' || j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    } else {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
