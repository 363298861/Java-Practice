package Leetcode;

public class No28ImplementStr {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        for(int i = 0; i < haystack.length(); i++){
            for(int j = 0; j < needle.length(); j++){
                if(needle.length() > haystack.length() - i) break;
                if(i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j))
                    break;
                if(j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }
}
