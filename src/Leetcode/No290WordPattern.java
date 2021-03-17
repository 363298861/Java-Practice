package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No290WordPattern {
    public boolean wordPattern(String pattern, String s) {
        if(pattern.isEmpty()) return true;
        Map<Character, String> map = new HashMap<>();
        String[] ss = s.split(" ");
        if(pattern.length() != ss.length) return false;
        for(int i = 0; i < pattern.length(); i++){
            if(!map.containsKey(pattern.charAt(i))){
                if(map.containsValue(ss[i]))
                    return false;
                else
                    map.put(pattern.charAt(i), ss[i]);
            }else{
                if(!ss[i].equals(map.get(pattern.charAt(i))))
                    return false;
            }
        }
        return true;
    }
}
