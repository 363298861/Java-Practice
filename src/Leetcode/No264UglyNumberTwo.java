package Leetcode;

public class No264UglyNumberTwo {

    public boolean isUgly(int num) {
        while(num % 2 == 0 || num % 3 == 0 || num % 5 == 0){
            if(num % 2 == 0)
                num /= 2;
            else if(num % 3 == 0)
                num /= 3;
            else if(num % 5 == 0)
                num /= 5;
        }
        return num == 1;
    }

    public int nthUglyNumber(int n) {
        int i = 0;
        int m = 1;
        while(i < n){
            if(isUgly(m))
                i++;
            m++;
        }
        return m - 1;
    }

    public int nthUglyNumberDP(int n){
        int[] res = new int[n];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for(int i  = 1; i < n; i++){
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if(res[i] == res[t2] * 2) t2++;
            if(res[i] == res[t3] * 3) t3++;
            if(res[i] == res[t5] * 5) t5++;
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        No264UglyNumberTwo n = new No264UglyNumberTwo();
        System.out.println(n.nthUglyNumber(1352));
    }
}
