package Leetcode;

public class No58LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean l = false;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' ' && !l){
                length++;
            }if(length != 0 && (s.charAt(i) == ' ' || i == 0))
                l = true;
        }
        if(l)
            return length;
        else
            return 0;
    }

    public static void main(String[] args) {
        String s = " a";
        No58LengthOfLastWord t = new No58LengthOfLastWord();
        System.out.println(t.lengthOfLastWord(s));
    }
}
