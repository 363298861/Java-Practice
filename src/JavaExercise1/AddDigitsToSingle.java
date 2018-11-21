package JavaExercise1;

import java.util.Scanner;

public class AddDigitsToSingle {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        String c = Integer.toString(b);
        while(c.length() != 1){
            int sum = 0;
            for(int i = 0; i < c.length(); i++){
                sum += c.charAt(i) - 48;
            }
            c = Integer.toString(sum);
        }
        System.out.println(c);
    }
}
