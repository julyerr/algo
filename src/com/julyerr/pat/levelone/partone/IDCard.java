package com.julyerr.pat.levelone.partone;

import java.util.*;

/*
测试用例:
5
320124198808240056
12010X198901011234
110108196711301866
37070419881216001X
320124198808240056

对应输出应该为:

12010X198901011234
110108196711301866
37070419881216001X

* */
public class IDCard {

    public static void main(String[] args) {
        int[] nums = new int[]{
                7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2
        };
        char[] chars = new char[]{
                '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'
        };
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            boolean passed = true;
            for (int i = 0; i < n; i++) {
                String input = scanner.next();
                int tmp = 0;
                for (int j = 0; j < input.length()-1; j++) {
                    tmp += (input.charAt(j)-'0')*nums[j];
                }
                tmp %=11;
                if(input.charAt(input.length()-1)!=chars[tmp]){
                    System.out.println(input);
                    passed = false;
                }
            }
            if(passed){
                System.out.println("All passed");
            }
        }
    }
}
