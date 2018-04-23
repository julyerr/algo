package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;

public class HighestLowest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String boyName = "";
            String boyId = "";
            int boyGrade = 101;

            String girllName = "";
            String girlId = "";
            int girlGrade = -1;

            for (int i = 0; i < n; i++) {
                String name = scanner.next();
                String gender = scanner.next();
                String id = scanner.next();
                int grade = scanner.nextInt();
                if (gender.equals("M")) {
                    if (boyGrade > grade) {
                        boyName = name;
                        boyId = id;
                        boyGrade = grade;
                    }
                } else {
                    if (girlGrade < grade) {
                        girllName = name;
                        girlId = id;
                        girlGrade = grade;
                    }
                }
            }
            boolean absent = false;
            if (girlGrade == -1) {
                absent = true;
                System.out.println("Absent");
            } else {
                System.out.println(girllName + " " + girlId);
            }
            if (boyGrade == 101) {
                System.out.println("Absent");
                absent = true;
            } else {
                System.out.println(boyName + " " + boyId);
            }
            if (absent) {
                System.out.println("NA");
            } else {
                System.out.println(girlGrade - boyGrade);
            }
        }
    }
}
