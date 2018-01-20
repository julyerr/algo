package com.julyerr.leetcode.hash;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        int ret = 0;
        for (int i = 2; i < n; i++) {
            if(isPrime(i)){
                ret++;
            }
        }
        return ret;
    }
    private boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

//    The Sieve of Eratosthenes 算法实现
    public int countPrimesII(int n) {
//        check validation
        if(n <= 2){
            return 0;
        }
        int[] nums = new int[n];
        int ret = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = 2; j*i < n; j++) {
                nums[j*i] = 1;
            }
        }
        for (int i = 2; i < n; i++) {
            if(nums[i] == 0){
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        CountPrimes countPrimes = new CountPrimes();
//        System.out.println(countPrimes.countPrimes(10));
        System.out.println(countPrimes.countPrimesII(15));
    }
}
