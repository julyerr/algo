package com.julyerr.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*
 * 参考解题思路：http://www.cnblogs.com/grandyang/p/5962508.html
 * 从边缘向中心不断的逼近，然后判断共同能够达到的点即可
 * */
public class PacificAtlantic {
    private int m, n;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> rt = new ArrayList<>();
        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return rt;
        }
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] visitedPacific = new boolean[m][n];
        boolean[][] visitedAtlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, visitedPacific, i, 0, Integer.MIN_VALUE);
            dfs(matrix, visitedAtlantic, i, n - 1, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix, visitedPacific, 0, i, Integer.MIN_VALUE);
            dfs(matrix, visitedAtlantic, m - 1, i, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedPacific[i][j] && visitedAtlantic[i][j]) {
                    rt.add(new int[]{i, j});
                }
            }
        }
        return rt;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int i, int j, int preHeight) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || matrix[i][j] < preHeight) {
            return;
        }
        visited[i][j] = true;
        dfs(matrix, visited, i - 1, j, matrix[i][j]);
        dfs(matrix, visited, i, j - 1, matrix[i][j]);
        dfs(matrix, visited, i + 1, j, matrix[i][j]);
        dfs(matrix, visited, i, j + 1, matrix[i][j]);
    }
}
