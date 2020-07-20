package Leetcode;

import java.util.Arrays;

public class No242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char[] t1 = t.toCharArray();
        Arrays.sort(t1);
        String s2 = Arrays.toString(s1);
        return Arrays.toString(s1).equals(Arrays.toString(t1));
    }

    public boolean isAnagram2(String s, String t){
        if(s.length() != t.length()) return false;
        int[] sa= new int[26];
        for(int i = 0; i < s.length(); i++){
            sa[s.charAt(i) - 'a']++;
            sa[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < s.length(); i++)
            if(sa[i] != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        No242ValidAnagram n242 = new No242ValidAnagram();
        System.out.println(n242.isAnagram2("tea", "ate"));
    }
}
