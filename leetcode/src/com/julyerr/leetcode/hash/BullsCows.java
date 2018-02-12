package com.julyerr.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are playing the following Bulls and Cows game with your friend:
 * You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess,
 * you provide a hint that indicates how many digits
 * in said guess match your secret number exactly in both digit and position (called "bulls")
 * and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 */
public class BullsCows {
    /**
     * 自己感觉思路没有问题，但是运行测试用例的时候（量较大，报错）
     *
     */
    //    public String getHint(String secret, String guess) {
//        int bulls,cows;
//        bulls = cows = 0;
//        if(secret.equals(guess)){
//            int length = secret.length();
//            return length+"A"+0+"B";
//        }
//        Map<Character,List<Integer>> map1 = new HashMap<>();
//        Map<Character,List<Integer>> map2 = new HashMap<>();
//        List<Integer> list;
//
//        mapSet(map1,secret);
//        mapSet(map2,guess);
//
//        List<Integer> l1,l2;
//        for (Character c :
//                map2.keySet()) {
//            if(map1.containsKey(c)){
//                l1 = map1.get(c);
//                l2 = map2.get(c);
////                get the smaller length
//                int m = l1.size() < l2.size()?l1.size():l2.size();
//                int n=0;
//                for (int i = 0; i < l1.size(); i++) {
//                    for (int j = 0; j < l2.size(); j++) {
//                        if(l1.get(i) == l2.get(j)){
//                            n++;
//                        }
//                    }
//                }
//                m -= n;
//                System.out.println(c+":"+m+":"+n);
//                bulls +=n;
//                cows += m;
//            }
//        }
//
//        return bulls+"A"+cows+"B";
//    }
//    public void mapSet(Map<Character,List<Integer>> map,String string){
//        List<Integer> list;
//        for (int i = 0; i < string.length(); i++) {
//            char c = string.charAt(i);
//            if(map.containsKey(c)){
//                list = map.get(c);
//            }else{
//                list = new ArrayList<>();
//            }
//            list.add(i);
//            map.put(c,list);
//        }
//    }

    /**
     * 原作者的思路比较巧妙，先计算出对应的bulls，然后计算出对应的cows，第二过程使用hash实现
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
//            check validation
        if (secret.equals(guess)) {
            return secret.length() + "A" + 0 + "B";
        }
        int bulls = 0;
        int cows = 0;
        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
//        count the bulls
        for (int i = 0; i < secret.length(); i++) {
            if (secretChars[i] == guessChars[i]) {
                secretChars[i] = guessChars[i] = '#';
                bulls++;
            }
        }
//        count the cows
        Map<Character, Integer> map = new HashMap<>();
        for (Character c :
                secretChars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Character c :
                guessChars) {
            if (c != '#' && map.containsKey(c) && map.get(c) != 0) {
                int t = map.get(c);
                t--;
                map.put(c, t);
                cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        String s1 = "1807";
        String s2 = "7810";
        BullsCows bullsCows = new BullsCows();
        System.out.println(bullsCows.getHint(s1, s2));
    }
}
