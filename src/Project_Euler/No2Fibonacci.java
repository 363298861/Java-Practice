package Project_Euler;

import java.util.ArrayList;
import java.util.List;

public class No2Fibonacci {
    public static void main(String[] args) {
        int i = 1; int j = 2; int sum = 0; int sum2 = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2);
        while(sum < 4000000){
            sum = i + j;
            list.add(sum);
            i = j;
            j = sum;
        }
        System.out.println(list);

        for(int x : list){
            if(x % 2 == 0)
                sum2 += x;
        }
        System.out.println(sum2);
    }
}
