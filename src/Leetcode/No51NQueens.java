package Leetcode;

import java.util.*;

public class No51NQueens {
    public List<List<String>> solveNQueens(int n) {
        int[] pos = new int[n + 1];
        List<List<String>> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        dfs(pos, n, 1, list);
        for(List<Integer> l : list){
            List<String> tmp = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                char[] c = new char[n];
                c[l.get(i) - 1] = 'Q';
                String s = new String(c).replace("\0", ".");
                tmp.add(s);
            }
            res.add(tmp);
        }
        return res;
    }

    public void dfs(int[] pos, int n, int start, List<List<Integer>> list){
        if(start > n){
            List<Integer> tmp = new ArrayList<>();
            for(int i : pos) {
                tmp.add(i);
            }
            list.add(tmp);
            return;
        }

        for(int j = 1; j <= n; j++){
            if(valid(pos, start, j)){
                pos[start] = j;
                dfs(pos, n, start + 1, list);
                pos[start] = 0;
            }
        }
    }

    private boolean valid(int[] pos, int row, int col){
        for(int i = 1; i < pos.length; i++){
            if(pos[i] != 0){
                if(i == row || pos[i] == col || (Math.abs(row - i) == Math.abs(col - pos[i]))){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        No51NQueens n = new No51NQueens();
        List<List<String>> res = n.solveNQueens(5);
        for(List l : res)
            System.out.println(l);
    }
}
