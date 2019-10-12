package Leetcode;

public class No14LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String res = "";
        char temp;
        int l = 0;
        while(l < strs[0].length()) {
            for (int i = 0; i < strs.length; i++) {
                temp = strs[0].charAt(l);
                if (l >= strs[i].length() || strs[i].charAt(l) != temp) {
                    return res;
                }
                if (i == strs.length - 1 && strs[i].charAt(l) == temp) {
                    l++;
                    res += temp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] t1 = {"aa","a"};
        No14LongestPrefix n = new No14LongestPrefix();
        System.out.println(n.longestCommonPrefix(t1));
    }
}
