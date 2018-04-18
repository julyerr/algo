package com.julyerr.pat.levelone.partone;

import java.math.BigInteger;
import java.util.Scanner;

public class AB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
//            直接使用java中提供的大数操作，也就没有什么考察能力（但是为了pass还是可以考虑的）
//            BigInteger bigInteger = scanner.nextBigInteger();
//            BigInteger b = scanner.nextBigInteger();
//            BigInteger[] bigIntegers = bigInteger.divideAndRemainder(b);
//            System.out.println(bigIntegers[0]+""+bigIntegers[1]);

            String first = scanner.next();
            int b = scanner.nextInt();
            if(first.length() == 1){
                int tmp = Integer.parseInt(first);
                System.out.println(tmp/b+" "+tmp%b);
            }else{
                int pre = first.charAt(0) - '0';
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i < first.length(); i++) {
                    int tmp = pre * 10 + first.charAt(i) - '0';
                    stringBuilder.append(tmp / b);
                    pre = tmp % b;
                }
                System.out.println(stringBuilder.toString() + " " + pre);
            }
        }
    }
}
