package Leetcode;

public class No125ValidPalindrome {
    public boolean isPalindrome(String s) {
        int first = 0, last = s.length() - 1;
        while(first < last){
            if(!Character.isLetterOrDigit(s.charAt(first))){
                first++;
            }else if(!Character.isLetterOrDigit(s.charAt(last))){
                last--;
            }else{
                if((Character.isDigit(s.charAt(first)) && !Character.isDigit(s.charAt(last))) ||
                        (!Character.isDigit(s.charAt(first)) && Character.isDigit(s.charAt(last)))){
                    System.out.println("here");
                    return false;
                }
                else if(s.charAt(first) != s.charAt(last) && Math.abs(s.charAt(first) - s.charAt(last)) != 32){
                    return false;
                }
                first++;
                last--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No125ValidPalindrome n = new No125ValidPalindrome();
        String t = "A man, a plan, a canal: Panama";
        String t2 = "0P";
        System.out.println(n.isPalindrome(t2));
    }
}
