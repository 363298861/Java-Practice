package JavaExercise1;

import java.nio.charset.Charset;

public class Exercise40 {
    public static void main(String[] args) {
        for(String s : Charset.availableCharsets().keySet())
            System.out.println(s);
    }
}
