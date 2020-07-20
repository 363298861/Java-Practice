package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        //combine(n, k, list, new ArrayList<>(), used);
        combineModified(n, k, list, new ArrayList<>(), 1);
        return list;
    }

    public void combine(int n, int k, List<List<Integer>> list, List<Integer> tmplist, boolean[] used){
        if(tmplist.size() == k) list.add(new ArrayList<>(tmplist));
        else{
            for(int i = 1; i <= n; i++){
                if(!used[i]){
                    if(tmplist.isEmpty() || tmplist.get(tmplist.size() - 1) < i) {
                        tmplist.add(i);
                        used[i] = true;
                        combine(n, k, list, tmplist, used);
                        tmplist.remove(tmplist.size() - 1);
                        used[i] = false;
                    }
                }
            }
        }
    }

    public void combineModified(int n, int k, List<List<Integer>> list, List<Integer> tmplist, int start){
        if(k == 0){
            list.add(new ArrayList<>(tmplist));
            return;
        }
        for(int i = start; i <= n; i++){
            tmplist.add(i);
            combineModified(n, k - 1, list, tmplist, i + 1);
            tmplist.remove(tmplist.size() - 1);
        }
    }

    public static void main(String[] args) {
        No77Combinations n = new No77Combinations();
        System.out.println(n.combine(4, 2));
    }
}
