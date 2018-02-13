package com.julyerr.niuke;

import java.util.Scanner;

/*
*   题目描述
A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
输入描述:
输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。 范围均在-30到30之间(闭区间)。
输出描述:
输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。 如果不存在这样的整数A，B，C，则输出No
示例1
输入

1 -2 3 4
输出

2 1 3
* */

/*
 * 简单的解方程,然后判断结果是否相等
 * */
public class CaddyNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int A_M_B = scanner.nextInt();
            int B_M_C = scanner.nextInt();
            int A_P_B = scanner.nextInt();
            int B_P_C = scanner.nextInt();
            int A_P_C_M_2B = A_M_B - B_M_C;
            int A_P_C_P_2B = A_P_B + B_P_C;
            int A_P_C = (A_P_C_M_2B + A_P_C_P_2B) >> 1;
            int A_P_B_P_C = (A_P_B + A_P_C + B_P_C) >> 1;
            int A = A_P_B_P_C - B_P_C;
            int B = A_P_B_P_C - A_P_C;
            int C = A_P_B_P_C - A_P_B;
//            chekc validations
            if (A - B != A_M_B || B - C != B_M_C) {
                System.out.println("No");
            } else {
                System.out.print(A + " ");
                System.out.print(B + " ");
                System.out.println(C);
            }
        }
    }
}
