package Leetcode;

public class No9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        else if(x < 10)
            return true;
        else{
            String n = Integer.toString(x);
            for(int i = 0; i < n.length() / 2; i++){
                if(n.charAt(i) != n.charAt(n.length() - i - 1))
                    return false;
            }
        }
        return true;
    }
}
