package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class No60PermutationSequence {

    public String getPermutation(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, res, new ArrayList<>());
        StringBuilder sb = new StringBuilder();
        for(int i : res.get(k - 1))
            sb.append(i);
        return sb.toString();
    }

    public void dfs(int n, int k, List<List<Integer>> res, List<Integer> list){
        if(res.size() == k)
            return;
        if(list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!list.contains(i)){
                list.add(i);
                dfs(n, k, res, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public String getPermutation2(int n, int k){
        StringBuilder res = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int t = 1;
        while(t <= n){
            int count = (k - 1) / factorial(n - t) + 1;
            int f = factorial(n - t++);
            k -= f * (count - 1);
            for(int i = 1; i <= n; i++){
                if(!list.contains(i)){
                    if(--count == 0){
                        list.add(i);
                        break;
                    }
                }
            }
        }
        for(int i : list)
            res.append(i);
        return res.toString();
    }

    public int factorial(int n){
        if(n == 0) return 1;
        return n == 1 ? 1 : n * factorial(n - 1);
    }

    public static void main(String[] args) {
        No60PermutationSequence n = new No60PermutationSequence();
        for(int i = 1; i < 25; i++)
            System.out.println(n.getPermutation2(4, i));
    }
}
