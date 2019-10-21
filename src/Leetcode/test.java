package Leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class test {
    public static void main(String[] args) {
        String s = "abc";
        List<String> res = new ArrayList<>();
        res.add("a");
        res.add("b");
        res.add("c");
        int t = res.size();
        for(int i = 0; i < s.length(); i++){
            String tem = Character.toString(s.charAt(i));
            for(int j = 0; j < t; j++){
                res.add(tem + res.get(j));

            }
        }
        int l = 0;
        while (l < t){
            res.remove(0);
            l++;
        }
    }
}
