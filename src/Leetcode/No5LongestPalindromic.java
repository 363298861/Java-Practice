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
    public String dp(String s){
        int l = s.length();
        boolean dp[][] = new boolean[l][l];
        String res = null;
        for(int i = l - 1; i >= 0; i--){
            for(int j = i; j < l; j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j] && (res == null || j - i + 1 > res.length()))
                    res = s.substring(i, j + 1);
            }
        }
        return res;
    }

    public String twoPointers(String s){
        int start = 0, length = 1;
        for(int i = 0; i < s.length(); i++){
            int l1 = extend(s, i, i);
            int l2 = extend(s, i, i + 1);
            if(length < l1 || length < l2){
                start = l1 > l2 ? i - l1 / 2 : i - l2 / 2 + 1;
                length = Math.max(l1, l2);
            }
        }
        return s.substring(start, start + length);
    }

    public int extend(String s, int i, int j){
        for(; i >= 0 && j < s.length(); i--, j++){
            if(s.charAt(i) != s.charAt(j))
                break;
        }
        return j - i - 1;
    }

}
