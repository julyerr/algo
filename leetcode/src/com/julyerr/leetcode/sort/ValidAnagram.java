package com.julyerr.leetcode.sort;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

/**
 * using the map record the count of different letters,if not equals just return false
 */


public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        if (s.equals(t)) {
            return false;
        }

        int[] map = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            map[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            int index = t.charAt(i) - 'a';
            map[index]--;
            if (map[index] < 0) {
                return false;
            }
        }
        for (int i = 0; i < 26; i++) {

            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
