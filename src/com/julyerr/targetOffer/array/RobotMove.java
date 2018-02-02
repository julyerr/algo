package com.julyerr.targetOffer.array;


/*
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * */

/**
 * 提交这道题目，关键是理解后面的可达性依赖于前面的可达性
 */
public class RobotMove {
    public int movingCount(int threshold, int rows, int cols) {
//        check validation
        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        int ret = 1;
        boolean[][] reachable = new boolean[rows][cols];
        reachable[0][0] = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i - 1 >= 0 && reachable[i - 1][j]) || (i + 1 < rows && reachable[i + 1][j]) ||
                        (j - 1 >= 0 && reachable[i][j - 1]) || (j + 1 < cols && reachable[i][j + 1])) {
                    if (getNumSum(i) + getNumSum(j) <= threshold) {
                        ret++;
                        reachable[i][j] = true;
                    }
                }
            }
        }
        return ret;
    }

    private int getNumSum(int num) {
        int ret = 0;
        while (num > 0) {
            ret += num % 10;
            num = num / 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        RobotMove robotMove = new RobotMove();
        System.out.println(robotMove.movingCount(10, 1, 100));
//        29 rather 64
    }
}

