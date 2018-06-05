package com.julyerr.leetcode.dynamic;

import java.util.List;

/*
 * 参考大神的解题思路：https://leetcode-cn.com/problems/shopping-offers/description/
 * */
public class Gouwujuan {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int ret = 0;
        int n = price.size();
        for (int i = 0; i < needs.size(); i++) {
            ret += needs.get(i) * price.get(i);
        }
        for (int i = 0; i < special.size(); i++) {
            List<Integer> list = special.get(i);
            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (needs.get(j) < list.get(j)) {
                    valid = false;
                }
                needs.set(j, needs.get(j) - list.get(j));
            }
            if (valid) {
                ret = Math.min(ret, shoppingOffers(price, special, needs) + list.get(n));
            }
            for (int j = 0; j < n; j++) {
                needs.set(j, needs.get(j) + list.get(j));
            }
        }
        return ret;
    }
}
