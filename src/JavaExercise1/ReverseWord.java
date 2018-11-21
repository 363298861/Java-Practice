package JavaExercise1;

import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String b = a.next();
        for(int i = 0; i < b.length(); i++)
            System.out.print(b.charAt(b.length()-1-i));
    }
}
