package JavaExercise1;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        if(isPalindrome(b))
            System.out.println("Yes");
        else
            System.out.println("NO");
    }

    private static boolean isPalindrome(int a) {
        for (int i = 0; i < Integer.toString(a).length() / 2; i++) {
            if (Integer.toString(a).charAt(i) != Integer.toString(a).charAt(Integer.toString(a).length() - i - 1))
                return false;
        }
        return true;
    }
}