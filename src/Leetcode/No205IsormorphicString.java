package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No205IsormorphicString {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if(s.length() == 0)
            return true;
        String cmp = "";
        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(map.containsKey(tmp)){
                cmp += map.get(tmp);
            }else{
                if(map.containsValue(t.charAt(i)))
                    return false;
                map.put(tmp, t.charAt(i));
                cmp += map.get(tmp);
            }
        }
        return cmp.equals(t);
    }

    public boolean isIsomorphicModified(String s, String t){
        int[] sl = new int[256];
        int[] tl = new int[256];
        for(int i = 0; i < s.length(); i++){
            if(sl[s.charAt(i)] != tl[t.charAt(i)])
                return false;
            sl[s.charAt(i)] = i + 1;
            tl[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "foo";
        String t2 = "fto";
        No205IsormorphicString n = new No205IsormorphicString();
        System.out.println(n.isIsomorphic(s, t2));
    }
}
