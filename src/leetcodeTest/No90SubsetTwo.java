package leetcodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90SubsetTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int start, List<List<Integer>> res, List<Integer> list){
        List<Integer> tmp = new ArrayList<>();
        for(int i : list){
            tmp.add(nums[i]);
        }
        res.add(tmp);
        for(int i = start; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && (list.isEmpty() || list.get(list.size() - 1) != i - 1))
                continue;
            list.add(i);
            dfs(nums, i + 1, res, list);
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] test = {5, 5, 5, 5, 5};
        No90SubsetTwo n = new No90SubsetTwo();
        System.out.println(n.subsetsWithDup(test));
    }
}
