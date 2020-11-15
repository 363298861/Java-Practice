package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No139WordBreak {
    boolean stop = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict.sort((s1, s2) -> (s2.length() - s1.length()));
        wordBreakModified(s, wordDict);
        return stop;
    }

    public void wordBreak(String s, List<String> wordDict, List<String> tmp){
        if(s.isEmpty()){
            stop = true;
            return;
        }

        for(int i = 1; i <= s.length(); i++){
            if(wordDict.contains(s.substring(0, i))){
                tmp.add(s.substring(0, i));
                wordBreak(s.substring(i), wordDict, tmp);
                if(stop) return;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public void wordBreakModified(String s, List<String> wordDict){
        if(s.isEmpty()){
            stop = true;
            return;
        }
        for(String word : wordDict){
            if(s.startsWith(word)){
                wordBreakModified(s.substring(word.length()), wordDict);
            }
        }
    }

    public boolean dp(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        No139WordBreak wb = new No139WordBreak();
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wb.wordBreak(s, list));
    }
}
