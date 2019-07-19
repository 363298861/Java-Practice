package Leetcode;

public class No7ReverseInteger {
    public static int reverse(int x) {
        if(x == 0)
            return 0;
        int n;
        if(x > 0)
            n = 1;
        else{
            n = -1;
            x = x * n;
        }
        String res = "";
        String num = Integer.toString(x);
        for(int i = num.length() - 1; i >= 0; i--){
            res += num.charAt(i);
        }
        System.out.println("x is: " + x);
        try{
            return n * Integer.parseInt(res);
        }catch (Exception e){
            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println(reverse(-214748348));
    }
}
