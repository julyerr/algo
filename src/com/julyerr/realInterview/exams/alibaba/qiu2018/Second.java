package com.julyerr.realInterview.exams.alibaba.qiu2018;

import java.util.Scanner;

public class Second {
    private static double minDis = Double.MAX_VALUE;
    public static boolean isInPolygon(Point point, Point[] points, int n) {
        int nCross = 0;
        for (int i = 0; i < n; i++) {
            Point p1 = points[i];
            Point p2 = points[(i + 1) % n];
            // 求解 y=p.y 与 p1 p2 的交点
            // p1p2 与 y=p0.y平行
            if (p1.y == p2.y)
                continue;
            // 交点在p1p2延长线上
            if (point.y < Math.min(p1.y, p2.y))
                continue;
            // 交点在p1p2延长线上
            if (point.y >= Math.max(p1.y, p2.y))
                continue;
            // 求交点的 X 坐标
            double x = (double) (point.y - p1.y) * (double) (p2.x - p1.x)
                    / (double) (p2.y - p1.y) + p1.x;
            // 只统计单边交点
            if (x > point.x)
                nCross++;
        }
        return (nCross % 2 == 1);
    }

    private static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        String first = scanner.nextLine();
        String[] firsts = first.split(",");
        Point start = new Point(Integer.parseInt(firsts[0]),Integer.parseInt(firsts[1]));
        String second = scanner.nextLine();
        String[] seconds = second.split(",");
        int n = seconds.length>>1;
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(Integer.parseInt(seconds[i*2]),Integer.parseInt(seconds[i*2]+1));
        }
        if(isInPolygon(start,points,n)){
            System.out.println("yes,0");
        }else{
            System.out.println("no,"+minDis);
        }
    }
}
