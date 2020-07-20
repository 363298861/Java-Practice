package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No93RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        restoreIpAddresses(s, 1, "", list);
        return list;
    }

    public void restoreIpAddresses(String s, int n, String tmpstr, List<String> list){
        if(n == 4 && Integer.parseInt(s) < 256){
            if(!Integer.toString(Integer.parseInt(s)).equals(s)) return;
            tmpstr += s;
            list.add(new String(tmpstr));
            return;
        }
        int l = s.length();
        for(int i = 1; i <= 3; i++){
            if(l - i >= (4 - n) && l - i <=  (4 - n) * 3 && Integer.parseInt(s.substring(0, i)) < 256){
                String t = s.substring(0, i);
                if(!Integer.toString(Integer.parseInt(t)).equals(t)) return;
                tmpstr += t + ".";
                restoreIpAddresses(s.substring(i), n + 1, tmpstr, list);
                tmpstr = tmpstr.substring(0, tmpstr.length() - i - 1);
            }
        }
    }

    public static void main(String[] args) {
        No93RestoreIPAddress n93 = new No93RestoreIPAddress();
        String s = "010010";
        System.out.println(n93.restoreIpAddresses(s));
    }
}
