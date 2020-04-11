package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class No3LongestSubstring {
    // Brute-force method
    /*public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)
            return 1;
        int length = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length() - 1; i++){
            set.add(s.charAt(i));
            for(int j = i + 1; j < s.length(); j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    if(j == s.length() - 1){
                        if(set.size() > length)
                            length = set.size();
                        set.clear();
                    }
                }else{
                    if(set.size() > length)
                        length = set.size();
                    set.clear();
                }
            }

        }
        return length;
    }*/

    private static int lengthOfLongestSubstring(String s){

        int num = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while(i < num && j < num){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int modified(String s){
        int cache[] = new int[256];
        int res = 0;

        for(int i = 0, j = 0; j < s.length(); i++){
            j = cache[s.charAt(i)] > 0 ? Math.max(j, cache[s.charAt(i)]) : j;
            cache[s.charAt(i)] = i + 1;
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int a = lengthOfLongestSubstring(" ");
        System.out.println(a);
    }
}
