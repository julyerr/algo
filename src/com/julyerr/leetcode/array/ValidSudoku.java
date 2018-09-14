package com.julyerr.leetcode.array;

import java.util.Arrays;

/*
 * 简单直观一点
 * */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return true;
        }
        boolean[] visited = new boolean[10];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int tmp = board[i][j] - '0';
                    if (visited[tmp]) {
                        return false;
                    }
                    visited[tmp] = true;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int tmp = board[j][i] - '0';
                    if (visited[tmp]) {
                        return false;
                    }
                    visited[tmp] = true;
                }
            }
        }
        for (int i = 3; i <= 9; i += 3) {
            for (int j = 3; j <= 9; j += 3) {
                Arrays.fill(visited, false);
                for (int k = i - 3; k < i; k++) {
                    for (int l = j - 3; l < j; l++) {
                        if (board[k][l] != '.') {
                            int tmp = board[k][l] - '0';
                            if (visited[tmp]) {
                                return false;
                            }
                            visited[tmp] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
