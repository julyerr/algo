package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

/*
* 需要明白题目意思，将10进制的数转换成radix进制之后，反转然后判断表示的数是否是素数
* */
public class ReversiblePrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int first = scanner.nextInt();
            if(first<0){
                break;
            }
            int radix = scanner.nextInt();
            int  sum = 0;
            if (!isPrime(first)) {
                System.out.println("No");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                while (first > 0) {
                    stringBuilder.append(first % radix);
                    first /= radix;
                }
                String second = stringBuilder.toString();

                for (int i = 0; i < second.length(); i++) {
                    sum = sum * radix + second.charAt(i) - '0';
                }
                if (isPrime(sum)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
        scanner.close();
    }

    private static boolean isPrime(int n) {
        if(n==1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
