package leetcodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40CombinationSumTwo {

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] candidates, int target, int sum, int start, List<Integer> list){
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start){
                if(candidates[i] == candidates[i - 1])
                    continue;
            }
            list.add(candidates[i]);
            dfs(candidates, target, sum + candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        No40CombinationSumTwo n = new No40CombinationSumTwo();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        n.combinationSum2(candidates, 8);
        System.out.println(n.res);
    }
}
