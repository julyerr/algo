package com.julyerr.leetcode.hash;

import java.util.*;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * <p>
 * Given "foo", "bar", return false.
 * <p>
 * Given "paper", "title", return true.
 * <p>
 * Note:
 * You may assume both s and t have the same length.
 */
public class Isomorphic {
    /**
     * 问题思考复杂了，不但复杂而且容易出错，还是没有发现中间的问题
     * <p>
     * //     * @param args
     */
//    public boolean isIsomorphic(String s, String t) {
//        if(s.equals(t)){
//            return true;
//        }else if(s.length() != t.length()){
//            return false;
//        }
//        Map<Character,List<Integer>> map1 = new LinkedHashMap<>();
//        Map<Character,List<Integer>> map2 = new LinkedHashMap<>();
//        List<List<Integer>> list1,list2;
//        help(s,map1);
//        help(t,map2);
//        list1 = new ArrayList<>(map1.values());
//        list2 = new ArrayList<>(map2.values());
//        if(list1.size() != list2.size()){
//            return false;
//        }
//        for (int i = 0; i < list1.size(); i++) {
//            List<Integer> list = list1.get(i);
//            if(list.size() != list2.get(i).size()){
//                return false;
//            }
//            for (int j = 0; j < list.size(); j++) {
//                if(list.get(j)!=list2.get(i).get(j)){
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }
//    private void help(String s,Map<Character,List<Integer>> map){
//        List<Integer> list;
//        for (int i = 0; i < s.length(); i++) {
//            Character c = s.charAt(i);
//            if(!map.containsKey(c)){
//                list = new ArrayList<>();
//            }else{
//                list = map.get(c);
//            }
//            list.add(i);
//            map.put(c,list);
//        }
//    }
    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        } else if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);
//            出现多对一的情况
            if (!map.containsKey(c1)) {
                if (map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            } else {
//                出现一对多的情况
                if (map.get(c1) != c2) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Isomorphic isomorphic = new Isomorphic();
        System.out.println(isomorphic.isIsomorphic("paper", "title"));
        System.out.println(isomorphic.isIsomorphic("foo", "bar"));
        System.out.println(isomorphic.isIsomorphic("add", "egg"));
    }
}
