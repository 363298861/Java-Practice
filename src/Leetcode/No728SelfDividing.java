package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No728SelfDividing {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++){
            int j;
            for(j = i; j > 0; j /= 10){
                if(j % 10 == 0 || i % (j % 10) != 0)
                    break;
            }
            if(j == 0) list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        No728SelfDividing n = new No728SelfDividing();
        System.out.println(n.selfDividingNumbers(1, 22));
    }
}
