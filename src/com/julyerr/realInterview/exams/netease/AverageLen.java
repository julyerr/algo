package com.julyerr.realInterview.exams.netease;

import java.util.Scanner;

public class AverageLen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int length = line.length();
            int kinds = 0;
            for (int i = 0; i < length; i++) {
                kinds++;
                while(i<length-1&& line.charAt(i) == line.charAt(i+1)){
                    i++;
                }
            }
            System.out.printf("%.2f\n",length/(1.0*kinds));
        }
    }
}
