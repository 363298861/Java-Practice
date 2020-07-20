package Leetcode;

public class No96UniqueBinaryTrees {
    public int numTrees(int n) {
        return numTrees(1, n);
    }

    public int numTrees(int start, int end){
        if(start > end) return 1;
        int left, right, res = 0;
        for(int i = start; i <= end; i++){
            left = numTrees(start, i - 1);
            right = numTrees(i + 1, end);
            res += left * right;
        }
        return res;
    }

    public int numTrees2(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                g[i] += g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }

    public static void main(String[] args) {
        No96UniqueBinaryTrees t = new No96UniqueBinaryTrees();
        System.out.println(t.numTrees(17));
    }
}
