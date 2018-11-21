package JavaExercise1;

import java.util.Scanner;

public class CommonDigit {
    public static void main(String[] args) {
        Scanner a  = new Scanner(System.in);
        int b = a.nextInt();
        int c = a.nextInt();
        String b1 = Integer.toString(b);
        String c1 = Integer.toString(c);
        if(b1.charAt(0) == c1.charAt(0) || b1.charAt(1) == c1.charAt(0)|| b1.charAt(0) == c1.charAt(1)|| b1.charAt(1) == c1.charAt(1))
            System.out.println(true);
        else
            System.out.println(false);
    }
}
