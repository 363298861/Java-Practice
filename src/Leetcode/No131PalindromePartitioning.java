package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        partition(s, list, new ArrayList<String>());
        return list;
    }

    public void partition(String s, List<List<String>> list, List<String> l){
        if(s.isEmpty()){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(isPalindrome(s.substring(0, i + 1))){
                l.add(s.substring(0, i + 1));
                partition(s.substring(i + 1), list, l);
                l.remove(l.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s){
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        No131PalindromePartitioning n = new No131PalindromePartitioning();
        String test = "aab";
        System.out.println(n.partition(test));
    }
}
