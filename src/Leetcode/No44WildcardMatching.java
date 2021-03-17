package Leetcode;

public class No44WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(s.isEmpty() && p.isEmpty())
            return true;
        if(p.isEmpty())
            return false;
        if(s.isEmpty()){
            if(p.charAt(0) == '*')
                return isMatch(s, p.substring(1));
            else
                return false;
        }

        if(p.charAt(0) == '?')
            return isMatch(s.substring(1), p.substring(1));
        if(p.charAt(0) != '*')
            return p.charAt(0) == s.charAt(0) && isMatch(s.substring(1), p.substring(1));
        if(p.length() > 1 && p.charAt(1) == '*')
            return isMatch(s, p.substring(1));

        return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));

    }

    public boolean isMatch2(String s, String p){
        int si = 0, pi = 0, match = 0, stari = -1;
        while(si < s.length()){
            if(pi < p.length() && (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))){
                si++; pi++;
            }else if(pi < p.length() && p.charAt(pi) == '*'){
                stari = pi;
                match = si;
                pi++;
            }else if(stari != -1){
                pi = stari + 1;
                si = ++match;
            }else
                return false;
        }
        while(pi < p.length() && p.charAt(pi) == '*')
            pi++;
        return pi == p.length();
    }

    public boolean isMatch3(String s, String p){
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char t = p.charAt(j - 1);
                if(t == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if(t != '*')
                    dp[i][j] = dp[i - 1][j - 1] && t == s.charAt(i - 1);
                else{
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        No44WildcardMatching n = new No44WildcardMatching();
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        System.out.println(n.isMatch3(s, p));
    }
}
