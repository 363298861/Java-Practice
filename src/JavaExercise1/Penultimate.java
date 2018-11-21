package JavaExercise1;

import java.util.Scanner;

public class Penultimate {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();
        String[] c = b.split(" ");
        System.out.println(c[c.length - 2]);
    }
}
