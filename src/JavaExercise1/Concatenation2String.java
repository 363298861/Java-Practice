package JavaExercise1;

import java.util.Scanner;

public class Concatenation2String {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String b = a.next();
        String c = a.next();
        System.out.println(b.substring(1,b.length()) + c.substring(1, c.length()));
    }
}
