package com.julyerr.targetOffer.hash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class FirstOccurrency {
    public int FirstNotRepeatingChar(String str) {
//        should not happend here
        if (str == null || str.length() == 0) {
            return -1;
        }
//        和输入的元素顺序相同
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character c :
                str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        FirstOccurrency firstOccurrency = new FirstOccurrency();
        System.out.println(firstOccurrency.FirstNotRepeatingChar("abaccdeff"));
    }
}
