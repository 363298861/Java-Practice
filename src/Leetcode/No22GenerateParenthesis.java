package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No22GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0) return list;
        generateParenthesis(n - 1, n, "(", list);
        return list;
    }

    public void generateParenthesis(int left, int right, String s, List<String> list){
        if(left < 0 || right < 0) return;
        if(left == 0 && right == 0) {
            list.add(s);
            return;
        }
        if(left == right){
            generateParenthesis(left - 1, right, s + "(", list);
            return;
        }
        generateParenthesis(left - 1, right, s + "(", list);
        generateParenthesis(left, right - 1, s + ")", list);
    }

    public static void main(String[] args) {
        No22GenerateParenthesis n22 = new No22GenerateParenthesis();
        System.out.println(n22.generateParenthesis(3));
    }
}
