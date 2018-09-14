package com.julyerr.realInterview.exams.pingduoduo.xiaozhao0830;

import java.util.*;

/*
3 4
COKE
TARN
SHOW
* */

public class Fourth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        char[][] matrix = new char[L][N];
        Set<String> set = new HashSet<>();
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            String word = scanner.next();
            set.add(word);
            strings[i] = word;
        }
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = strings[j].charAt(i);
            }
            Arrays.sort(matrix[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (found(set, 0, L, 0, matrix, stringBuilder)) {
            System.out.println(stringBuilder.toString());
        } else {
            System.out.println("-");
        }
    }

    private static boolean found(Set<String> set,  int index, int len, int start, char[][] matrix, StringBuilder stringBuilder) {
        if (start >= len) {
            if (!set.contains(stringBuilder.toString())) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (i > 0 && matrix[start][i] == matrix[start][i - 1]) {
                continue;
            }
            stringBuilder.append(matrix[start][i]);
            if (found(set, index + 1, len, start+1, matrix, stringBuilder)) {
                return true;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return false;
    }
}
