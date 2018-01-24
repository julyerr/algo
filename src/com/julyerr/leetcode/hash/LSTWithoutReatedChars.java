package com.julyerr.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LSTWithoutReatedChars {
    /**
     * 中间思考可能出现了，问题后面弥补起来更加复杂
     * @param args
     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        int left = 0;
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            Character character = s.charAt(i);
////            和下一个元素发生重复
//            if (i + 1 < s.length() && map.containsKey(character) && (character == s.charAt(i + 1))) {
//                map.put(character, i+1);
//                left = i+1;
//                continue;
//            }
////            和已经访问过的元素出现了重复
//            if (map.containsKey(character) && map.get(character) >= left) {
//                left = map.get(character) + 1;
//                while (left < i && s.charAt(left) == s.charAt(left + 1)) {
//                    left++;
//                }
//            }
//            map.put(character, i);
//            max = Math.max(max, i + 1 - left);
//        }
//        return max;
//    }

    /**
     * 作者的思路，保证max和每次的无重复序列长度比较
     * 但是通过从后到前的思路，解决了很多问题
     * //     * @param args
     */
    public int lengthOfLongestSubstring(String s) {
//            check validation
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 1;
        int barrier = 0;
        char[] chars = s.toCharArray();
//            判断条件把握得很好
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j >= barrier; j--) {
                if (chars[i] == chars[j]) {
                    barrier = j + 1;
                    break;
                }
            }
            max = Math.max(max, i + 1 - barrier);
        }

        return max;
    }

    /**
     * leetcode上看到大神的解决方法，使用hash但是非常精简
     * //     * @param args
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return -0;
        }
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
//                精简之道
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }


    public static void main(String[] args) {
        LSTWithoutReatedChars lstWithoutReatedChars = new LSTWithoutReatedChars();
        System.out.println(lstWithoutReatedChars.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lstWithoutReatedChars.lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lstWithoutReatedChars.lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lstWithoutReatedChars.lengthOfLongestSubstring2("cdd"));
        System.out.println(lstWithoutReatedChars.lengthOfLongestSubstring2("abba"));
        System.out.println(lstWithoutReatedChars.lengthOfLongestSubstring2("uqinntq"));
        System.out.println(lstWithoutReatedChars.lengthOfLongestSubstring2("lwphapjnadqhdcnvwdtxjbmypppha"));
    }
}
