package com.julyerr.realInterview.exams.niuke.one;

import java.util.Scanner;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/aaad2e0e1dc74d5da4587ad7f6e0de8d
 * 主要是k=4的情况的特殊处理，其他的很好理解。
 * K>=5时，可以任取最大值即可；
 * k<=3，直接暴力求解；
 * k=4，可以选择到3个最大的col，然后对于剩余的2个col遍历比较，具体参见实现代码
 * */
public class SimpleDevice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] devices = new int[N][5];
            int[] maxCols = new int[5];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 5; j++) {
                    devices[i][j] = scanner.nextInt();
                    maxCols[j] = Math.max(maxCols[j], devices[i][j]);
                }
            }
            int tmp = 0;
            if (K >= 5) {
                for (int i = 0; i < 5; i++) {
                    tmp += maxCols[i];
                }
                System.out.println(tmp);
            } else {
                if (K == 1) {
                    for (int i = 0; i < N; i++) {
                        int tmpSum = 0;
                        for (int j = 0; j < 5; j++) {
                            tmpSum += devices[i][j];
                        }
                        tmp = Math.max(tmp, tmpSum);
                    }
                } else if (K == 2) {
                    for (int i = 0; i < N - 1; i++) {
                        for (int j = i + 1; j < N; j++) {
                            int tmpSum = 0;
                            for (int k = 0; k < 5; k++) {
                                tmpSum += Math.max(devices[i][k], devices[j][k]);
                            }
                            tmp = Math.max(tmp, tmpSum);
                        }
                    }
                } else if (K == 3) {
                    for (int i = 0; i < N - 2; i++) {
                        for (int j = i + 1; j < N - 1; j++) {
                            for (int k = j + 1; k < N; k++) {
                                int tmpSum = 0;
                                for (int l = 0; l < 5; l++) {
                                    tmpSum += Math.max(devices[i][l], Math.max(devices[j][l], devices[k][l]));
                                }
                                tmp = Math.max(tmp, tmpSum);
                            }
                        }
                    }
                } else {
//                    如果直接暴力求解的话，会超时
                    for (int i = 0; i < 5; i++) {
                        for (int j = i + 1; j < 5; j++) {
                            int maxTwoCol = 0;
//                            挑选任意两个cols和的最大值
                            for (int k = 0; k < N; k++) {
                                maxTwoCol = Math.max(maxTwoCol, devices[k][i] + devices[k][j]);
                            }
                            int tmpSum = maxTwoCol;
//                            从最大的cols中取出剩余的三个col
                            for (int k = 0; k < 5; k++) {
                                if (k != i && k != j) {
                                    tmpSum += maxCols[k];
                                }
                            }
//                            比较更新
                            tmp = Math.max(tmp, tmpSum);
                        }
                    }

                }
                System.out.println(tmp);
            }
        }
    }
}
