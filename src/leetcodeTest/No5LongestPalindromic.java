package leetcodeTest;

public class No5LongestPalindromic {
    public String longestPalindrome(String s) {
        String longest = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = s.length(); j > i; j--){
                if(isPalindrome(s.substring(i, j))){
                    if(j - i > longest.length())
                        longest = s.substring(i, j);
                    break;
                }
            }
        }
        return longest;
    }

    public boolean isPalindrome(String s){
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i))
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

    public static void main(String[] args) {
        No5LongestPalindromic n = new No5LongestPalindromic();
        System.out.println(n.twoPointers("babad"));
    }
}
