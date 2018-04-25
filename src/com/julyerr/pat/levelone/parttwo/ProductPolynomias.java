package com.julyerr.pat.levelone.parttwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 此题有一个精度问题，这里就不细细深究了
 * */
public class ProductPolynomias {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Node[] result = new Node[2001];
            List<Node> first = new ArrayList<>(), second = new ArrayList<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int e = scanner.nextInt();
                double xishu = scanner.nextDouble();
                first.add(new Node(e, xishu));
            }
            n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int e = scanner.nextInt();
                double xishu = scanner.nextDouble();
                second.add(new Node(e, xishu));
            }

            int count = 0;
            int maxe = 0;
            for (int i = 0; i < first.size(); i++) {
                for (int j = 0; j < second.size(); j++) {
                    int e = first.get(i).e + second.get(j).e;
                    double xishu = first.get(i).xishu * second.get(j).xishu;
                    if (Math.abs(xishu) > 1e-7) {
                        if (result[e] == null) {
                            result[e] = new Node(e, xishu);
                            count++;
                        } else {
                            result[e].xishu += xishu;
                            if (Math.abs(result[e].xishu) < 1e-7) {
                                result[e] = null;
                                count--;
                            }
                        }
                    }
                    maxe = Math.max(maxe, e);
                }
            }
            System.out.print(count);
            for (int i = maxe; i >= 0; i--) {
                if (result[i] != null) {
                    System.out.printf(" %d %.1f", result[i].xishu);
                }
            }
            System.out.println();
        }
    }

    private static class Node {
        int e;
        double xishu;

        public Node(int e, double xishu) {
            this.e = e;
            this.xishu = xishu;
        }
    }
}
