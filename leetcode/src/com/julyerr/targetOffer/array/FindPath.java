package com.julyerr.targetOffer.array;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

/**
 * 典型的递归和回溯的方法，注意边界的条件判断
 */
public class FindPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
//       check validation
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0) {
            return false;
        }
        char[][] path = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                path[i][j] = matrix[i * cols + j];
            }
        }
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (path[i][j] == str[0] && matched(i, j, path, visited, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean matched(int x, int y, char[][] path, boolean[][] visited, char[] str, int index) {
        visited[x][y] = true;
        index++;
        if (index == str.length) {
            return true;
        }
        if (x - 1 >= 0 && !visited[x - 1][y] && path[x - 1][y] == str[index] && matched(x - 1, y, path, visited, str, index)) {
            return true;
        }
        if (x + 1 < path.length && !visited[x + 1][y] && path[x + 1][y] == str[index] && matched(x + 1, y, path, visited, str, index)) {
            return true;
        }
        if (y - 1 >= 0 && !visited[x][y - 1] && path[x][y - 1] == str[index] && matched(x, y - 1, path, visited, str, index)) {
            return true;
        }
        if (y + 1 < path[0].length && !visited[x][y + 1] && path[x][y + 1] == str[index] && matched(x, y + 1, path, visited, str, index)) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        FindPath findPath = new FindPath();
        String matrix = "abcesfcsadee";
//        String str = "bcced";
        String str = "abcb";
        System.out.println(findPath.hasPath(matrix.toCharArray(), 3, 4, str.toCharArray()));
    }
}
