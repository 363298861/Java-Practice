package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No17LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        Map<Integer, String> numbers = new HashMap<>();
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for(int i = 2; i < 10; i++){
            numbers.put(i, letters[i - 2]);
        }
        if(digits.length() == 1){
            List<String> res = new ArrayList<>();
            String s = numbers.get(Integer.parseInt(digits));
            for(int i = 0; i < s.length(); i++){
                res.add(Character.toString(s.charAt(i)));
            }
            return res;
        }
        else{
            List<String> res = letterCombinations(digits.substring(1));
            String s = numbers.get(Integer.parseInt(digits.substring(0, 1)));
            int t = res.size();
            for(int i = 0; i < s.length(); i++){
                String tem = Character.toString(s.charAt(i));
                for(int j = 0; j < t; j++){
                    res.add(tem + res.get(j));
                }
            }
            int l = 0;
            while (l < t){
                res.remove(0);
                l++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        No17LetterCombinations t = new No17LetterCombinations();
        System.out.println(t.letterCombinations("227"));
    }
}
