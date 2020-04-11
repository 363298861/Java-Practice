package Leetcode;

public class No8Atoi {
    public int myAtoi(String str) {

        str = str.trim();
        if(str.isEmpty() || !Character.isDigit(str.charAt(0)))
            return 0;

        String res = "";
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i)))
                break;
            res += str.charAt(i);
        }
        int a = Integer.parseInt(res);
        return a;
    }
}
