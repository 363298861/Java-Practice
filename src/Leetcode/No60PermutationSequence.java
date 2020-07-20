package Leetcode;

public class No60PermutationSequence {
    public String getPermutation(int n, int k) {
        String res = "";
        boolean[] used = new boolean[n];
        for(int i = 0; i < n; i++){
            int fac = factorial(n - i - 1);
            res += element(n, (k - 1) / fac, used);
            k = k % fac;
            if(k == 0) k = fac;
        }
        return res;
    }

    public int factorial(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        return n * factorial(n - 1);
    }

    public int element(int n, int k, boolean[] used){
        int nth = 0;
        for(int i = 0; i < n; i++){
            if(used[i]) continue;
            if(nth == k){
                used[i] = true;
                return i  + 1;
            }
            if(!used[i]){
                nth++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        No60PermutationSequence n = new No60PermutationSequence();
        System.out.println(n.getPermutation(4, 9));
    }
}
