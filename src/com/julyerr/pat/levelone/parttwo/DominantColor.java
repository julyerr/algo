package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

public class DominantColor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int out = -1;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int tmp = scanner.nextInt();
                    if (tmp == out) {
                        count++;
                    } else {
                        if (count == 0) {
                            count = 1;
                            out = tmp;
                        } else {
                            count--;
                        }
                    }
                }
            }
            System.out.println(out);
        }
    }
}
