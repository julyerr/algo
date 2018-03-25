package com.julyerr.realInterview.exams.tencent;

public class Geohash {
    public String geohash(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int left = -90;
        int right = 90;
        for (int i = 0; i < 6; i++) {
            int mid = (left + right) / 2;
            if (n < mid) {
                right = mid;
                stringBuilder.append(0);
            } else if (n >= mid) {
                left = mid;
                stringBuilder.append(1);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        Geohash geohash = new Geohash();
        System.out.println(geohash.geohash(80));
    }
}
