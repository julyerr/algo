import java.util.*;

public class Main {
    public static void main(String[] args) {
    }

    public void handle(int[][] matrix, int x, int y) {
        int xlen = matrix.length;
        int ylen = matrix[0].length;
        int[] xs = new int[]{-1, 0, 1};
        int[] ys = new int[]{-1, 0, 1};
        node[] nodes = new node[8];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int xl = x + xs[i];
                int yl = y + ys[j];
                if (xl >= 0 && xl < xlen && yl >= 0 && yl < ylen) {
                    if (matrix[x + xs[i]][y + ys[j]] != 0) {
                        return;
                    } else if (j != 0) {
                        nodes[index].x = xl;
                        nodes[index++].y = yl;
                    }
                }
            }
        }
        for (int i = 0; i < index; i++) {
            handle(matrix, nodes[i].x, nodes[i].y);
        }

    }

    class node {
        int x;
        int y;
    }

    public int Fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
//      首先保证代码的robust，其次保证代码的简洁性
        int[] dp = new int[n + 3];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
