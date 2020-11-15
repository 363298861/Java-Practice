package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No204CountPrimeNumber {
    public int countPrimes(int n) {
        int res = 0;
        for(int i = 1; i < n; i += 2){
            if(isPrime(i)) {
                res++;
                System.out.println(i);
            }
        }
        if(n >= 2) res++;
        return res;
    }

    public int countPrimesModify(int n){
        List<Integer> list = new ArrayList<>();

        for(int i = 2; i < n; i++){
            if(isPrime(i, list)) list.add(i);
        }
        return list.size();
    }

    public boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2; i < n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public boolean isPrime(int n, List<Integer> list){
        for(int i : list){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public int countPrimes2(int n){
        boolean[] notprime = new boolean[n];
        int counter = 0;
        for(int i = 2; i < n; i++){
            if(!notprime[i])
                counter++;
            for(int j = 2; i * j < n; j++)
                notprime[i * j] = true;
        }
        return counter;
    }

    public int countPrimesUltimate(int n){
        if(n < 3) return 0;
        int c = n / 2;
        boolean[] f = new boolean[n];
        for(int i = 3; i * i < n; i += 2){
            if(f[i]) continue;
            for(int j = i * i; j < n; j += 2 * i){
                if(!f[j]){
                    c--;
                    f[j] = true;
                }
            }
        }
        return c;
    }


    public static void main(String[] args) {
        No204CountPrimeNumber n = new No204CountPrimeNumber();
        System.out.println(n.countPrimesUltimate(499979));
    }
}
