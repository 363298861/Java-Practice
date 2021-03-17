package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No970PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        int t;
        for(int i = 0; ; i++){
            int j;
            for(j = 0; ; j++){
                t = (int) (Math.pow(x, i) + Math.pow(y, j));
                System.out.println(t);
                if(t <= bound && !list.contains(t))
                    list.add(t);
                else if(t > bound || (x == 1 || y == 1))
                    break;
            }
            if(j == 0)
                break;
        }
        return list;
    }

    public static void main(String[] args) {
        No970PowerfulIntegers n = new No970PowerfulIntegers();
        System.out.println(n.powerfulIntegers(2, 1, 10));
    }
}
