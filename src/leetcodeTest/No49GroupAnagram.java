package leetcodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No49GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] t = new char[26];
            for (int i = 0; i < s.length(); i++) {
                t[s.charAt(i) - 'a']++;
            }
            String key = new String(t);
            List<String> tmp = map.getOrDefault(key, new ArrayList<>());
            tmp.add(s);
            map.put(key, tmp);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {


    }
}
