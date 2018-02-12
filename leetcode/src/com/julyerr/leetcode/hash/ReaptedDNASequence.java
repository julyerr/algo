package com.julyerr.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 *  When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

 Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

 For example,

 Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

 Return:
 ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class ReaptedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rt = new ArrayList<>();
        if(s == null || s.length() < 10){
            return rt;
        }
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String tmp = s.substring(i,i+10);
            if(map.containsKey(tmp) && !rt.contains(tmp)){
                rt.add(tmp);
            }else{
                map.put(tmp,1);
            }
        }
        return rt;
    }
    public static void main(String[] args){
        ReaptedDNASequence reaptedDNASequence = new ReaptedDNASequence();
//        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s = "AAAAACCCCC";
        List<String> list = reaptedDNASequence.findRepeatedDnaSequences(s);
        for (String str :
                list) {
            System.out.println(str);
        }
    }
}
