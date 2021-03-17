package Leetcode;

public class No43MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int r = (num1.charAt(m - 1 - i) - '0') * (num2.charAt(n - 1 - j) - '0');
                int hi = i + j + 1, lo = i + j;
                r += res[lo];
                res[lo] = r % 10;
                res[hi] += r / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = m + n - 1; i >= 0; i--){
            if(!(sb.length() == 0 && res[i] == 0))
                sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        No43MultiplyStrings n = new No43MultiplyStrings();
        System.out.println(n.multiply("34", "62"));
    }
}
