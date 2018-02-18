package com.julyerr.niuke;

import java.util.Scanner;

public class Hexadecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            boolean isMinus = false;
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            if(M < 0){
                isMinus = true;
                M = Math.abs(M);
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (M > 0) {
                int tmp = M % N;
                M = M / N;
                if (tmp > 9) {
                    stringBuilder.append((char) (tmp - 10 + 'A'));
                } else {
                    stringBuilder.append(tmp);
                }
            }
            System.out.println((isMinus?"-":"")+stringBuilder.reverse().toString());
        }
    }
}
