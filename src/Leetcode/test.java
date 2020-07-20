package Leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.add(0);
        System.out.println(list);
        String a = "A man, a plan, a canal: Panama";
        for(int i = 0; i < a.length(); i++)
            System.out.println(Character.isLetter(a.charAt(i)));
    }
}
