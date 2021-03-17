package leetcodeTest;

public class No9PalidromeNumber {
    public boolean isPalindrome(int x){
        if(x < 0) return false;
        int t = x;
        int palindrome = 0;
        while(x > 0){
            palindrome *= 10;
            palindrome += x % 10;
            x /= 10;
        }
        return palindrome == t;
    }
}

