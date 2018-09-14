package com.julyerr.leetcode.array;

import java.util.*;

/*
参考思路：
https://blog.csdn.net/qq508618087/article/details/51295751
* */
public class TopK {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return list;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.times - o1.times;
            }
        });
        for (Integer key:
             map.keySet()) {
            priorityQueue.add(new Node(key,map.get(key)));
        }
        for (int i = 0; i < k; i++) {
            list.add(priorityQueue.poll().val);
        }
        return list;
    }

    private static class Node{
        int val,times;

        public Node(int val, int times) {
            this.val = val;
            this.times = times;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        System.out.println(new TopK().topKFrequent(nums,k));
    }
}
