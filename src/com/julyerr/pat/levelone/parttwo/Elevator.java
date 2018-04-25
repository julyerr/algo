package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = 0;
            int cur = 0;
            while (n-- > 0) {
                int next = scanner.nextInt();
                if (next > cur) {
                    sum += (next - cur) * 6 + 5;
                } else{
                    sum += (cur - next) * 4 + 5;
                }
                cur = next;
            }
            System.out.println(sum);
        }
    }
}
