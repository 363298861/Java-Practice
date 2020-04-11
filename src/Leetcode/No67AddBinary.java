package Leetcode;

public class No67AddBinary {
    public String addBinary(String a, String b) {
        String res = "";
        int al = a.length();
        int bl = b.length();
        boolean extra = false;
        int l = Math.max(a.length(), b.length());
        if(l == a.length()){
            a = "0" + a;
            while(b.length() <= l){
                b = "0" + b;
            }
        }else {
            b = "0" + b;
            while(a.length() <= l){
                a = "0" + a;
            }
        }
        System.out.println("a is: " + a);
        System.out.println("b is: " + b);

        while(l >= 0){
            if(extra){
                if(a.charAt(l) == '0' && b.charAt(l) == '0') {
                    res = "1" + res;
                    l--;
                    extra = false;
                }else if(a.charAt(l) == '1' && b.charAt(l) == '1'){
                    res = "1" + res;
                    l--;
                }else{
                    res = "0" + res;
                    l--;
                }
            }else{
                if(a.charAt(l) == '0' && b.charAt(l) == '0') {
                    res = "0" + res;
                    l--;
                }else if(a.charAt(l) == '1' && b.charAt(l) == '1'){
                    res = "0" + res;
                    l--;
                    extra = true;
                }else{
                    res = "1" + res;
                    l--;
                }
            }
        }
        if(res.charAt(0) == '0')
            return res.substring(1);
        return res;
    }

    public static void main(String[] args) {
        No67AddBinary t = new No67AddBinary();
        String a = "0";
        String b = "0";
        System.out.println(t.addBinary(a, b));
    }
}
