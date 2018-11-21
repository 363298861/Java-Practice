package DataStructure02;

import java.util.Scanner;

public class CircularShift {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        if( (a.length() == b.length()) && (a.concat(a).indexOf(b) >= 0))
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
