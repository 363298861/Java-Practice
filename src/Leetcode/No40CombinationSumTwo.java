package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tmplist, int[] candidates, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0 && !list.contains(tmplist)) list.add(new ArrayList<>(tmplist));
        else{
            for(int i = start; i < candidates.length; i++){
                tmplist.add(candidates[i]);
                backtrack(list, tmplist, candidates, remain - candidates[i], i + 1);
                tmplist.remove(tmplist.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] t = {10, 1, 2, 7, 6, 1, 5};
        No40CombinationSumTwo n = new No40CombinationSumTwo();
        System.out.println(n.combinationSum2(t, 8));
    }
}
