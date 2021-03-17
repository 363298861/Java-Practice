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

    public int reverse2(int x){
        int res = 0;
        while(x != 0){
            int tail = x % 10;
            int newRes = res * 10 + tail;
            if((newRes - tail) / 10 != res) return 0;
            res = newRes;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-214748348));
    }
}
