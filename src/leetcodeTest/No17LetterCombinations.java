package leetcodeTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No17LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        if(!digits.isEmpty())
            queue.offer("");
        for(int i = 0; i < digits.length(); i++){
            int l = queue.size();
            int n = digits.charAt(i) - 50;
            for(int j = 0; j < l; j++){
                String prefix = queue.poll();
                for(int k = 0; k < letters[n].length(); k++){
                    String tmp = prefix + letters[n].charAt(k);
                    queue.offer(tmp);
                }
            }

        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        No17LetterCombinations n = new No17LetterCombinations();
        System.out.println(n.letterCombinations("23"));
    }
}
