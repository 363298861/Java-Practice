package Leetcode;

public class No13RomanToInteger {
    public int romanToInt(String s){
        int res = 0;
        String[] roman = {"M", "D", "C", "L", "X", "V", "I"};
        int[] num = {1000, 500, 100, 50, 10, 5, 1};
        for(int i = 0; i < s.length(); i++){
            if(i < s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M'){
                res += 900;
                i++;
            } else if(i < s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D'){
                res += 400;
                i++;
            }else if(i < s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C'){
                res += 90;
                i++;
            }else if(i < s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L'){
                res += 40;
                i++;
            }else if(i < s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X'){
                res += 9;
                i++;
            }else if(i < s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V'){
                res += 4;
                i++;
            }
            else{
                for(int j = 0; j < roman.length; j++){
                    if(s.charAt(i) == roman[j].charAt(0)){
                        res += num[j];
                        break;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        No13RomanToInteger t = new No13RomanToInteger();
        System.out.println(t.romanToInt("III"));
    }
}
