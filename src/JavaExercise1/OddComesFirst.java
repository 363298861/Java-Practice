package JavaExercise1;

import java.util.ArrayList;
import java.util.Arrays;

public class OddComesFirst {
    public static int[] oddFirst(int[] arr){
        ArrayList<Integer> x = new ArrayList<>();
        for(int n = 0; n < arr.length; n++){
            if (arr[n] % 2 == 0){
                x.add(arr[n]);
            }
        }
        for(int n = 0; n < arr.length; n++){
            if (arr[n] % 2 != 0){
                x.add(arr[n]);
            }
        }
        int[] y = x.stream().mapToInt(i -> i).toArray();
        return y;
    }

    public static void main(String[] args) {
        int[] u = {1, 4, 3, 5, 6, 7, 1, 3, 4, 67 ,8, 9,9,0,7,6,5,};
        for(int t : oddFirst(u))
            System.out.print(t + ", ");
        System.out.println(Arrays.toString(oddFirst(u)));
    }
}
