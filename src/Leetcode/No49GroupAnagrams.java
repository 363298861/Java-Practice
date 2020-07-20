package Leetcode;

import java.util.*;

public class No49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if(strs.length == 0) return list;
        List<String> tmplist = new ArrayList<>();
        tmplist.add(strs[0]);
        list.add(tmplist);
        for(int i = 1; i < strs.length; i++){
            for(int j = 0; j < list.size(); j++){
                if(isAnagram(list.get(j).get(0), strs[i])) {
                    list.get(j).add(strs[i]);
                    break;
                }
                if(j == list.size() - 1){
                    List<String> l = new ArrayList<>();
                    l.add(strs[i]);
                    list.add(l);
                    break;
                }
            }
        }
        return list;
    }

    public boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)) {
                    s2 = s2.substring(0, j) + s2.substring(j + 1);
                    break;
                }
                if(j == s2.length() - 1)
                    return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams2(String[] strs){
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keystr = String.valueOf(ca);
            if(!map.containsKey(keystr))
                map.put(keystr, new ArrayList<>());
            map.get(keystr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs){
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] ca = new int[26];
            for(char c : s.toCharArray()) ca[c - 'a']++;
            String key = Arrays.toString(ca);
            List<String> tmplist = map.getOrDefault(key, new ArrayList<>());
            tmplist.add(s);
            map.put(key, tmplist);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        No49GroupAnagrams n49 = new No49GroupAnagrams();
        String[] s = {"ate", "eat", "tea", "tan", "nat", "bat"};
        String[] s1 = {"", "b"};
        System.out.println(n49.groupAnagrams(s1));
    }
}
