package Leetcode;

public class No10RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        /*if(s.isEmpty() && p.isEmpty())
            return true;
        else if(s.isEmpty() || p.isEmpty())
            return false;
        int j = 0;
        int i = 0;
        Character r = null;
        if(s.charAt(i) == p.charAt(j)){
            if(j < p.length() - 1 && p.charAt(j + 1) == '*'){
                int n = i + 1;
                while(n < s.length() && s.charAt(n) == s.charAt(i))
                    n++;
                return isMatch(s.substring(n), p.substring(j + 2));
            }else{
                return isMatch(s.substring(i + 1), p.substring(j + 1));
            }
        }else if(p.charAt(j) == '.'){
            if(j < p.length() - 1 && p.charAt(j + 1) == '*'){
                return j + 2 == p.length();
            }else{
                return isMatch(s.substring(i + 1), p.substring(j + 1));
            }
        }
        else{
            if(j < p.length() - 1 && p.charAt(j + 1) == '*')
                return isMatch(s, p.substring(j + 2));
            else
                return false;
        }*/
        if(p.isEmpty())
            return s.isEmpty();
        boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if(p.length() > 1 && p.charAt(1) == '*')
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
        else
            return first_match && isMatch(s.substring(1), p.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(isMatch("mississppi", "mis*is*p*."));
    }
}
