package JavaExercise1;

import java.util.Scanner;

public class Capitalize_first_letter {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();
        Scanner x = new Scanner(b);
        System.out.print((char) (b.charAt(0) - 32));
        System.out.print(b.charAt(1));
        for(int i = 1; i < b.length() - 1; i++){
            if(b.charAt(i) == 32)
                System.out.print(" "+(char)(b.charAt(i + 1) - 32));
            else
                System.out.print(b.charAt(i + 1));
        }
    }
}
