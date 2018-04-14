package com.julyerr.realInterview.exams.Qiniu.chunzhao2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            while (n-- > 0) {
                List<List<Integer>> rt = new ArrayList<>();
                boolean ok = true;
                while (true) {
//                    规定空白行结束
                    String tmp = scanner.nextLine();
                    if (tmp.equals(" ")) {
                        break;
                    }
                    String[] strings = tmp.split(" ");
                    List<Integer> list = new ArrayList<>();
                    for (int i = 0; i < strings.length; i++) {
                        list.add(Integer.parseInt(strings[i]));
                        if (i != 0 && list.get(i - 1) >= list.get(i)) {
                            ok = false;
                        }
                    }
                    rt.add(list);
                }
                if (ok) {
                    for (int i = 1; i < rt.size(); i++) {
                        List<Integer> pre = rt.get(i - 1);
                        List<Integer> cur = rt.get(i);
                        if (pre.size() < cur.size()) {
                            ok = false;
                            break;
                        } else {
                            for (int j = 0; j < cur.size(); j++) {
                                if (pre.get(j) >= cur.get(j)) {
                                    ok = false;
                                    break;
                                }
                            }
                        }
                    }
                }
                System.out.println(ok);
            }
        }
        scanner.close();
    }
}
