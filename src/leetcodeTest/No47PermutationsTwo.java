package leetcodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47PermutationsTwo {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list){
        if(list.size() == nums.length){
            List<Integer> tmp = new ArrayList<>();
            for(int i : list)
                tmp.add(nums[i]);
            res.add(tmp);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(list.contains(i))
                continue;
            if(i > 0 && nums[i] == nums[i - 1] && !list.contains(i - 1))
                continue;
            list.add(i);
            dfs(nums, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        No47PermutationsTwo n = new No47PermutationsTwo();
        int[] nums = {1, 1, 1, 3};
        System.out.println(n.permuteUnique(nums));
    }
}
