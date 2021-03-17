package leetcodeTest;

public class No14LongestPrefix {
    public String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";
        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            for(int j = 0; j < res.length(); j++){
                if(j >= strs[i].length() || res.charAt(j) != strs[i].charAt(j)){
                    res = res.substring(0, j);
                    break;
                }
            }
            if(res.isEmpty()) break;
        }
        return res;
    }
}
