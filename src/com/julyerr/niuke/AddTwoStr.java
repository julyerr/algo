package com.julyerr.niuke;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 此题没有明确说明是正负号，如果存在正负的话计算较为复杂，考虑使用lib中提供的大数的计算方法
 * 如果只是正数相加减的话，还是比较简单的
 * */
public class AddTwoStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.next();
            String second = scanner.next();

            int lenA = first.length() - 1;
            int lenB = second.length() - 1;
//            first.length >= second.length
            if (lenA < lenB) {
                String tmp = first;
                first = second;
                second = tmp;
            }
            StringBuilder stringBuilder = new StringBuilder();
            int carry = 0;
            boolean valid = true;
            while (lenA >= 0 || lenB >= 0) {
                int a = 0;
                int b = 0;
                if (lenA >= 0) {
                    if (!Character.isDigit(first.charAt(lenA))) {
                        valid = false;
                        break;
                    }
                    a = first.charAt(lenA--) - '0';
                }
                if (lenB >= 0) {
                    if (!Character.isDigit(second.charAt(lenB))) {
                        valid = false;
                        break;
                    }
                    b = second.charAt(lenB--) - '0';
                }
                a += b + carry;
                carry = a / 10;
                a = a % 10;
                stringBuilder.append(a);
            }
            if (valid) {
//                添加计算的进位等
                if (carry != 0) {
                    stringBuilder.append(carry);
                }
//                从后面计算到前面需要反转
                System.out.println(stringBuilder.reverse().toString());
            } else {
                System.out.println("Error");
            }
        }
    }

    //    使用库函数
    private String addTwoStr(String a, String b) {
        BigInteger aB = new BigInteger(a);
        BigInteger bB = new BigInteger(b);
        return aB.add(bB).toString();
    }
}
