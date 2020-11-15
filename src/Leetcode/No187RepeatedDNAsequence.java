package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No187RepeatedDNAsequence {
    public List<String> findRepeatedDnaSequencesBruteForce(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i <= s.length() - 10; i++){
            for(int j = i + 1; j <= s.length() - 10; j++){
                if(s.substring(i, i + 10).equals(s.substring(j, j + 10))){
                    if(!list.contains(s.substring(i, i + 10)))
                        list.add(s.substring(i, i + 10));
                }
            }
        }
        return list;
    }

    public List<String> findRepeatedDnaSequences(String s){
        List<String> list = new ArrayList<>();
        for(int i = 0; i <= s.length() - 10; i++){
            for(int j = i + 1; j <= s.length() - 10; j++){
                int k = 0;
                for(k = 0; k < 10; k++){
                    if(s.charAt(i + k) != s.charAt(j + k))
                        break;
                }
                if(k == 10){
                    if(!list.contains(s.substring(i, i + 10)))
                        list.add(s.substring(i, i + 10));
                    break;
                }
            }
        }
        return list;
    }

    public List<String> findRepeatedDnaSequencesModified(String s){
        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
        for(int i = 0; i < s.length() - 9; i++){
            String t = s.substring(i, i + 10);
            if(!seen.add(t))
                repeated.add(t);
        }
        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        No187RepeatedDNAsequence n = new No187RepeatedDNAsequence();
        String t = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(n.findRepeatedDnaSequences(t));
    }
}
