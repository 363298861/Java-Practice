package Java;

import java.util.ArrayList;

public class MakePI {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(MakePi1(10)[10]);
        }

    }

    public static int[] MakePi1(int aaa) {
        ArrayList<Integer> re = new ArrayList<Integer>();
        String a = Math.PI + "";
        for(int i = 0; i < aaa; i++){
            re.add(Integer.parseInt(Character.toString(a.charAt(i))));
        }
        return re.stream().mapToInt(k -> k).toArray();
    }
}
