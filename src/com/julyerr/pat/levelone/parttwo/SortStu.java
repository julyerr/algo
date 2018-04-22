package com.julyerr.pat.levelone.parttwo;

import java.util.*;

public class SortStu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Stu[] stus = new Stu[n];
            for (int i = 0; i < n; i++) {
                stus[i] = new Stu(scanner.next(), scanner.next(), scanner.nextInt());
            }
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (stus[i].grade >= start && stus[i].grade <= end) {
                    stus[index++] = stus[i];
                }
            }
            Arrays.sort(stus, 0, index, new Comparator<Stu>() {
                @Override
                public int compare(Stu o1, Stu o2) {
                    return o2.grade - o1.grade;
                }
            });
            if(index==0){
                System.out.println("NONE");
            }else{
                for (int i = 0; i < index; i++) {
                    System.out.println(stus[i].name + " " + stus[i].id + " " + stus[i].grade);
                }
            }
        }
    }

    private static class Stu {
        String name, id;
        int grade;

        public Stu(String name, String id, int grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }
    }
}
