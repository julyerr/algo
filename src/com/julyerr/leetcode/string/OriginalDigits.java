package com.julyerr.leetcode.string;

/*
根据每个数字的特点进行去重判断，中间调整字母特点
* */
public class OriginalDigits {
    public String originalDigits(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int[] nums = new int[10];
        help(count, nums, 0, 'z', new char[]{'r', 'o'});
        help(count, nums, 2, 'w', new char[]{'o'});
        help(count, nums, 4, 'u', new char[]{'o', 'r', 'f'});
        help(count, nums, 6, 'x', new char[]{'s'});
        help(count, nums, 8, 'g', null);

        help(count, nums, 1, 'o', new char[]{'n'});
        help(count, nums, 3, 'r', null);
        help(count, nums, 5, 'f', null);
        help(count, nums, 7, 's', new char[]{'n'});
        nums[9] = count['n' - 'a'] >> 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }

    private void help(int[] count, int[] nums, int index, char c, char[] chars) {
        int delta = c - 'a';
        int times = count[delta];
        nums[index] += times;

        count[delta] -= times;
        if (chars != null) {
            for (int i = 0; i < chars.length; i++) {
                char tmp = chars[i];
                count[tmp - 'a'] -= times;
            }
        }
    }

    public static void main(String[] args) {
        String s = "owoztneoer";
        System.out.println(new OriginalDigits().originalDigits(s));
    }
}
