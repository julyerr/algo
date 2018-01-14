package com.julyerr.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

/**
 * for every three digits just dfs
 */
public class RestoreIp {
    List<String> rt = new ArrayList<String>();
    String[] stack = new String[4];
    public List<String> restoreIpAddress(String s){
        if(s == null || s.length() ==0){
            return new ArrayList<String>();
        }
        dfs(s,0,0);
        return rt;
    }
    public void dfs(String s,int p,int pStack){
        if(pStack == 4 && p >= s.length()){
            String ip = String.join(".",stack);
            rt.add(ip);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if(p+i > s.length()){
                return;
            }
            if(s.charAt(p) =='0' && i> 1){
                return;
            }
            String number  = s.substring(p,p+i);
            if(Integer.parseInt(number) <= 255){
                stack[pStack] = number;
                dfs(s,p+i,pStack+1);
            }
        }
    }
}
