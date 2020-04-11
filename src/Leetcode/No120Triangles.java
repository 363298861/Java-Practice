package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No120Triangles {
    public int minimumTotal(List<List<Integer>> triangle) {
        int l = triangle.size();
        int[] dp = new int[triangle.get(l - 1).size()];
        for(List<Integer> list : triangle){
            if(list.size() == 1){
                dp[0] = list.get(0);
                continue;
            }
            int tmp, oldtmp = dp[0] + list.get(0);
            for(int i = 1; i < list.size(); i++){
                tmp = (i != list.size() - 1 && dp[i] < dp[i - 1]) ? dp[i] + list.get(i) : dp[i - 1] + list.get(i);
                dp[i - 1] = oldtmp;
                oldtmp = tmp;
                if(i == list.size() - 1)
                    dp[i] = oldtmp;
            }
        }
        int min = dp[0];
        for(int i = 0; i < dp.length; i++){
            if(min > dp[i])
                min = dp[i];
        }
        return min;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3); b.add(4);
        List<Integer> c = new ArrayList<>();
        c.add(6); c.add(5);c.add(7);
        List<Integer> d = new ArrayList<>();
        d.add(4); d.add(1);d.add(8);d.add(3);
        List<List<Integer>> t = new ArrayList<>();
        t.add(a);t.add(b);
        t.add(c);t.add(d);
        No120Triangles n = new No120Triangles();
        System.out.println(n.minimumTotal(t));
    }
}
