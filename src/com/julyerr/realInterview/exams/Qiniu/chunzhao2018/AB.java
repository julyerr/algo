package com.julyerr.realInterview.exams.Qiniu.chunzhao2018;

/*
* 2
ABCCBA
Yes
ABCCCCCBBBBB
* */
import java.util.Scanner;

public class AB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            while (n-- > 0) {
                String line = scanner.next();
                StringBuilder sb = new StringBuilder(line);
                boolean flag = true;
                while (true) {
                    flag = true;
                    StringBuilder tmp = new StringBuilder();
                    int length = sb.length();
                    for (int i = 0; i < length; i++) {
                        if (i + 1 < length && sb.charAt(i) == sb.charAt(i + 1)) {
                            i++;
                            flag = false;
                        } else {
                            tmp.append(sb.charAt(i));
                        }
                    }
                    sb = tmp;
                    if (flag) {
                        break;
                    }
                }
                if (sb.length()==0) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
        scanner.close();
    }
}
