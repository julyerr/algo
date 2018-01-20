package com.julyerr.leetcode.hash;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"]
 */

/**
 * 处理过程较为复杂一点，但是思路还是很清晰的
 */
public class Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rt = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0){
            return rt;
        }
        Map<String,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            List<Integer> list;
            if(map.containsKey(tmp)){
                list = map.get(tmp);
            }else{
//                generate a new array
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(tmp,list);
        }
        for (Map.Entry<String, List<Integer>> entry :
                map.entrySet()) {
            List<Integer> group = entry.getValue();
            List<String> strGroup = new ArrayList<>();
            for (Integer i:
                 group ) {
                strGroup.add(strs[i]);
            }
//            sort the strs
            strGroup.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            rt.add(strGroup);
        }
        return rt;
    }
    public static void main(String[] args){
        Anagrams anagrams = new Anagrams();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        anagrams.groupAnagrams(strs);
    }
}
