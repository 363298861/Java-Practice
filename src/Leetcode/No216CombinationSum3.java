package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No216CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum3(k, n, res, new ArrayList<>(), 0, 1);
        return res;
    }

    public void combinationSum3(int k, int n, List<List<Integer>> res, List<Integer> list, int sum, int start){
        if(sum == n && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(list.size() >= k || sum > n) return;

        for(int i = start; i < 10; i++){
            list.add(i);
            combinationSum3(k, n, res, list, sum + i, i + 1);
            list.remove(Integer.valueOf(i));
        }
    }

    public static void main(String[] args) {
        No216CombinationSum3 n = new No216CombinationSum3();
        System.out.println(n.combinationSum3(3, 7));
    }
}
