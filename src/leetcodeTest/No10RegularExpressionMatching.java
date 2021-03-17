package leetcodeTest;

public class No10RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // The first condition can be simplified
        if(p.isEmpty()){
            if(s.isEmpty()) return true;
            else return false;
        }
        if(s.isEmpty()){
            if(p.length() >= 2 && p.charAt(1) == '*')
                return isMatch(s, p.substring(2));
            else
                return false;
        }
        if(p.length() >= 2 && p.charAt(1) == '*'){
            if(p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            else
                return isMatch(s, p.substring(2));
        }else{
            if(p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))
                return isMatch(s.substring(1), p.substring(1));
            else
                return false;
        }
    }
    // This one is faster
    public boolean isMatchSimplified(String s, String p){
        if(p.isEmpty()) return s.isEmpty();
        if(p.length() >= 2 && p.charAt(1) == '*'){
            if(!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            else
                return isMatch(s, p.substring(2));
        }else if(!s.isEmpty() && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)))
            return isMatch(s.substring(1), p.substring(1));
        return false;
    }

    public boolean dp(String s, String p){
        // dp means the first i characters can match the first j characters
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for(int j = 1; j < p.length(); j += 2){
            if(p.charAt(j) == '*' && dp[0][j - 1])
                dp[0][j + 1] = true;
        }

        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if(sc == pc || pc == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(pc == '*'){
                    if(p.charAt(j - 2) != '.' && p.charAt(j - 2) != sc)
                        dp[i][j] = dp[i][j - 2];
                    else
                        dp[i][j] = dp[i - 1][j - 2] || dp[i - 1][j] || dp[i][j - 2];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        No10RegularExpressionMatching n = new No10RegularExpressionMatching();
        System.out.println(n.isMatch("aa", "a*"));
    }
}
