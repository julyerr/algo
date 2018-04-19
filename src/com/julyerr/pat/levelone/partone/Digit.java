package com.julyerr.pat.levelone.partone;

import java.util.Scanner;

public class Digit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sum = scanner.nextInt() + scanner.nextInt();
            int D = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            while (sum > 0) {
                stringBuilder.append(sum % D);
                sum /= D;
            }
            System.out.println(stringBuilder.reverse().toString());
        }
    }
}
