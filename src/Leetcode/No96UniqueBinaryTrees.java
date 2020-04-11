package Leetcode;

public class No96UniqueBinaryTrees {
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++)
                g[i] += g[i - j - 1] * g[j];
        }
        return g[n];
    }

    public static void main(String[] args) {
        No96UniqueBinaryTrees t = new No96UniqueBinaryTrees();
        System.out.println(t.numTrees(4));
    }
}
