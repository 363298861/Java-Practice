package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No119PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();


        for(int i = 0; i <= rowIndex; i++){
            list.add(0, 1);
            for(int j = 1; j < i; j++){
                list.set(j, list.get(j + 1) + list.get(j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        No119PascalTriangle2 n = new No119PascalTriangle2();
        System.out.println(n.getRow(1));
    }
}
