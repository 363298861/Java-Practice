package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class No77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int n, int k, int start, List<Integer> list, List<List<Integer>> res){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= n; i++){
            list.add(i);
            dfs(n, k, i +1, list, res);
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args) {
        No77Combinations n = new No77Combinations();
        System.out.println(n.combine(4, 2));
    }
}
