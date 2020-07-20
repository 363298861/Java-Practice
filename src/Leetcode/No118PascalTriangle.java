package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No118PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);

        for(int i = 1; i < numRows; i++){
            List<Integer> tmp, last;
            tmp = new ArrayList<>();
            last = list.get(i - 1);

            for(int j = 0; j <= i; j++){
                if(j == 0){
                    tmp.add(last.get(0));
                }else if(j == i){
                    tmp.add(last.get(i - 1));
                }else{
                    tmp.add(last.get(j - 1) + last.get(j));
                }
            }

            list.add(tmp);
        }
        return list;
    }

    public static void main(String[] args) {
        No118PascalTriangle n = new No118PascalTriangle();
        System.out.println(n.generate(5));
    }
}
