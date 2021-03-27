package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class No93RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(String s, int start, List<String> res, List<Integer> list){
        if(list.size() == 4 && start >= s.length()){
            StringBuilder tmp = new StringBuilder();
            for(int i = 0; i < list.size(); i++){
                tmp.append(list.get(i));
                if(i != list.size() - 1)
                    tmp.append('.');
            }
            res.add(tmp.toString());
            return;
        }else if(list.size() == 4 || start >= s.length())
            return;
        for(int j = 1; j < 4 && start + j <= s.length(); j++){
            int tmp = Integer.parseInt(s.substring(start, start + j));
            if(j == 1 || (s.charAt(start) != '0' && tmp < 256)){
                list.add(tmp);
                dfs(s, start + j, res, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        String s1 = "1111";
        No93RestoreIPAddresses n = new No93RestoreIPAddresses();
        System.out.println(n.restoreIpAddresses(s));
    }
}
