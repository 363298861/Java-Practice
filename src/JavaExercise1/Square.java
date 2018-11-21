package JavaExercise1;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        for(int i =0; i < b; i++){
            if(i * i == b)
                System.out.println(i);
        }
    }
}
