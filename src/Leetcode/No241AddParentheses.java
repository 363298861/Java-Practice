package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No241AddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(!Character.isDigit(c)){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for(Integer l : left){
                    for(Integer r : right){
                        switch (c){
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if(list.size() == 0) {
            list.add(Integer.parseInt(input));
        }
        return list;
    }

    public static void main(String[] args) {
        String test = "2*3-4*5";
        No241AddParentheses n = new No241AddParentheses();
        System.out.println(n.diffWaysToCompute(test));
    }
}
