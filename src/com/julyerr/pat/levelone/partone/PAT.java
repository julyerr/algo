package com.julyerr.pat.levelone.partone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

//直接暴力求解超时
public class PAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            int p, a, t;
            p = a = t = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'T') {
                    t++;
                }
            }
            long sum = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == 'A') {
                    a++;
                    sum = (sum + p * t) % 1000000007;
                } else if (c == 'P') {
                    p++;
                } else {
                    t--;
                }
            }
            System.out.println(sum);
        }
    }

}
