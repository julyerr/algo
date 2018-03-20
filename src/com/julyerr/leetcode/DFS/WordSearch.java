package com.julyerr.leetcode.DFS;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
//        需要验证的条件较多
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        xLen = board.length;
        yLen = board[0].length;
//        不能出现重复访问同一个位置的情况
        boolean[][] visited = new boolean[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
//                每次访问从头开始
                if (finded(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean finded(char[][] board, int x, int y, String string, int index, boolean[][] visited) {
        if (index == string.length()) {
            return true;
        }
        if (x < 0 || x >= xLen || y < 0 || y >= yLen) {
            return false;
        }
//        没有被访问过，并且相等
        if (!visited[x][y] && string.charAt(index) == board[x][y]) {
            visited[x][y] = true;
//            dfs判断上下左右位置
            if (finded(board, x + 1, y, string, index + 1, visited) || finded(board, x, y + 1, string, index + 1, visited) ||
                    finded(board, x - 1, y, string, index + 1, visited) || finded(board, x, y - 1, string, index + 1, visited)) {
                return true;
            }
            visited[x][y] = false;
        }
        return false;
    }

    private int xLen, yLen;

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        String word = "ABCCED";
//        String word = "SEE";
        String word = "ABCB";
        System.out.println(wordSearch.exist(board, word));
    }
}
