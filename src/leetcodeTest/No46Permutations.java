package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class No46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, new ArrayList<>());
        return list;
    }
    public void dfs(int[] nums, List<List<Integer>> list, List<Integer> l){
        if(l.size() == nums.length) {
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!l.contains(nums[i])) {
                l.add(nums[i]);
                dfs(nums, list, l);
                l.remove(l.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        No46Permutations n = new No46Permutations();
        System.out.println(n.permute(nums));
    }
}
