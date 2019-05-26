package Leetcode;

public class No5LongestPalindromic {
    public String longestPalindrome(String s) {
        int  lo = 0, hi = 1;
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length() - 1; j > i + hi - lo - 1; j--){
                if(isPalindromic(s.substring(i, j + 1)) && j + 1 - i > hi - lo){
                    hi = j + 1;
                    lo = i;
                    break;
                }
            }
        }
        return hi == 1 ? s.substring(0, 1) : s.substring(lo, hi);
    }

    private boolean isPalindromic(String t){
        for(int i = 0; i < t.length() / 2; i++){
            if(t.charAt(i) != t.charAt(t.length() - 1 - i))
                return false;
        }
        return true;
    }


}
