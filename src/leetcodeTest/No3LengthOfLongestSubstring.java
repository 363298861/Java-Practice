package leetcodeTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No3LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); j++){
                if(set.contains(s.charAt(j))){
                    if(j - i > res)
                        res = j - i;
                    break;
                }else if(j == s.length() - 1){
                    if(j - i + 1 > res)
                        res = j - i + 1;
                }
                set.add(s.charAt(j));
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s){
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        No3LengthOfLongestSubstring n = new No3LengthOfLongestSubstring();
        System.out.println(n.lengthOfLongestSubstring2("abba"));
    }
}
