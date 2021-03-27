package Leetcode;

public class No76MinimumSubstring {
    public String minWindow(String s, String t) {
        char[] tc = new char[52];
        for(int i = 0; i < t.length(); i++){
            int idx = t.charAt(i) > 90 ? t.charAt(i) - 'a' : t.charAt(i) - 'A' + 26;
            tc[idx]++;
        }
        int min = 0, left = 0, right = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                char[] sc = new char[52];
                for(int k = i; k <= j; k++){
                    int idx = s.charAt(k) > 90 ? s.charAt(k) - 'a' : s.charAt(k) - 'A' + 26;
                    if(tc[idx] != '\0' && sc[idx] < tc[idx]) sc[idx]++;
                }
                if(new String(sc).equals(new String(tc))){
                    if(min == 0 || j + 1 - i < min){
                        min = j + 1 - i;
                        left = i; right = j + 1;
                    }
                }
            }
        }
        return s.substring(left, right);
    }

//    public String minWindow2(String s, String t){
//        int[] map = new int[128];
//        for(int i = 0; i < t.length(); i++){
//            map[t.charAt(i)]++;
//        }
//        int counter = t.length(), lo = 0, hi = 0, min = Integer.MAX_VALUE, head = 0;
//        while(hi < s.length()){
//            if(map[s.charAt(hi++)]-- > 0) counter--;
//            while(counter == 0){
//                if(hi - lo < min) min = hi - lo;
//                head = lo;
//                if(map[s.charAt(lo++)]++ == 0) counter++;
//            }
//        }
//        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
//    }

    public String minWindow2(String s, String t){
        int[] map = new int[128];
        for(int i = 0; i < t.length(); i++)
            map[t.charAt(i)]++;

        int lo = 0, hi = 0, counter = t.length(), head = 0, min = Integer.MAX_VALUE;
        while(hi <= s.length()){
            if(map[s.charAt(hi++)]-- > 0) counter--;
            while(counter == 0){
                if(hi - lo < min){
                    min = hi - lo;
                    head = lo;
                }
                if(map[s.charAt(lo++)]++ == 0) counter++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }

    public static void main(String[] args) {
        No76MinimumSubstring n = new No76MinimumSubstring();
        String s = "ADOBECODEBANC", t = "ABC";
        String s1 = "a", t1 = "aa";
        System.out.println(n.minWindow2(s, t));
    }
}
