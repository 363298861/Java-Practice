package leetcodeTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No22GenerateParetheses {
    public List<String> generateParenthesis(int n) {
        Queue<String> queue = new LinkedList<>();
        if(n == 0) return new ArrayList<>(queue);
        queue.offer("()");
        for(int i = 1; i < n; i++){
            int l = queue.size();
            for(int j = 0; j < l; j++){
                String tmp = queue.poll();
                for(int k = 0; k < tmp.length(); k++){
                    String t = tmp.substring(0, k) + "()" + tmp.substring(k);
                    if(!queue.contains(t)) queue.offer(t);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public List<String> DFS(int n){
        List<String> list = new ArrayList<>();
        helper(n,  "", list, 0, 0);
        return list;
    }

    public void helper(int n, String s, List<String> list, int open, int close){
        if(s.length() == 2 * n){
            list.add(s);
            return;
        }
        if(open < n)
            helper(n, s + "(", list, open + 1, close);
        if(close < open)
            helper(n, s + ")", list, open, close + 1);
    }

    public static void main(String[] args) {
        No22GenerateParetheses n = new No22GenerateParetheses();
        System.out.println(n.DFS(3));
    }
}
