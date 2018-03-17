package com.julyerr.niuke;

import java.util.Scanner;

public class ListSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            double start = n * 1.00;
            double sum = 0;
            while(m-- >0){
                sum += start;
                start = Math.sqrt(start);
            }
            System.out.printf("%.2f\n",sum);
        }
    }
}
