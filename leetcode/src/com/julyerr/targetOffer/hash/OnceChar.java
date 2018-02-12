package com.julyerr.targetOffer.hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流google中只读出前两个字符go时，第一个只出现一次的字符是g；
 * 当读完google时，第一个只出现一次的字符是l。
 */
public class OnceChar {
    //Insert one char from stringstream
    private Queue<Character> queue = new LinkedList<>();
    private Map<Character, Integer> map = new HashMap<>();
    private char cur = '#';

    //    插入元素的时候进行更新，调用获取元素的时候直接返回
    public void Insert(char ch) {
        if (!map.containsKey(ch)) {
            map.put(ch, 1);
            queue.add(ch);
            if (cur == '#') {
                cur = ch;
            }
        } else {
            if (cur == ch) {
                queue.poll();
                cur = '#';
//                fetch new elem
                while (!queue.isEmpty()) {
                    if (map.get(queue.peek()) == 2) {
                        queue.poll();
                    } else {
                        cur = queue.peek();
                        break;
                    }
                }
            } else {
                map.put(ch, 2);
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return cur;
    }
}
