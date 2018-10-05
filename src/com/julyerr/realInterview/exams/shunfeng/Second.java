package com.julyerr.realInterview.exams.shunfeng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new Node());
        }

        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextInt();
            map.get(nums1[i]).val1 = i;
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
            map.get(nums2[i]).val2 = i;
        }

        int rt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = nums1[i];
                int b = nums1[j];
                if (!compare(map.get(a), map.get(b))) {
                    rt++;
                }
            }
        }
        System.out.println(rt);
    }

    private static class Node {
        int val1, val2;
    }

    private static boolean compare(Node node1, Node node2) {
        int a = node1.val1 - node2.val1;
        int b = node1.val2 - node2.val2;
        if (a < 0 && b < 0 || a > 0 && b > 0) {
            return true;
        }
        return false;
    }
}
