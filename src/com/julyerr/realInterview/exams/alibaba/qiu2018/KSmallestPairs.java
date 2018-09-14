package com.julyerr.realInterview.exams.alibaba.qiu2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
* 没有思路直接使用暴力求解的方式进行
*
* http://www.cnblogs.com/grandyang/p/5653127.html
* */
public class KSmallestPairs {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                list.add(new Node(nums1[i], nums2[j]));
            }
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.a + o1.b - (o2.a + o2.b);
            }
        });
        List<int[]> rt = new ArrayList<>();
        for (int i = 0; i < k && i < list.size(); i++) {
            rt.add(new int[]{list.get(i).a, list.get(i).b});
        }
        return rt;
    }

    private static class Node {
        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
