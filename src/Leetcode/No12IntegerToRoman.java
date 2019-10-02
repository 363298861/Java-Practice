package Leetcode;

public class No12IntegerToRoman {
    public String intToRoman(int num) {
        String res = "";
        int t;
        for(int j = 0; j < (num / 1000); j++)
            res += "M";

        if((t = (num % 1000) / 100) != 0){
            if(t == 9){
                res += "CM";
                t = 0;
            }
            if(t == 4){
                res += "C";
                t += 1;
            }
            for(int i = 0; i < t / 5; i++) {
                res += "D";
                t = t % 5;
            }
            for(int i = 0; i < t; i++)
                res += "C";
        }

        if((t = ((num % 1000) % 100) / 10) != 0){
            if(t == 9){
                res += "XC";
                t = 0;
            }
            if(t == 4){
                res += "X";
                t += 1;
            }
            for(int i = 0; i < t / 5; i++) {
                res += "L";
                t = t % 5;
            }
            for(int i = 0; i < t; i++)
                res += "X";
        }

        if((t = ((num % 1000) % 100) % 10) != 0){
            if(t == 9){
                res += "IX";
                t = 0;
            }
            if(t == 4){
                res += "I";
                t += 1;
            }
            for(int i = 0; i < t / 5; i++) {
                res += "V";
                t = t % 5;
            }
            for(int i = 0; i < t; i++)
                res += "I";
        }
        return res;

    }

    public static void main(String[] args) {
        No12IntegerToRoman t = new No12IntegerToRoman();
        System.out.println(t.intToRoman(3));
        System.out.println(t.intToRoman(4));
        System.out.println(t.intToRoman(9));
        System.out.println(t.intToRoman(58));
        System.out.println(t.intToRoman(1994));
    }
}
