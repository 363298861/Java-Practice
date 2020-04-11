package Leetcode;

public class No278FirstBadVersion {
    boolean isBadVersion(int version){
        return false;
    }

    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while(i < j){
            int mid = (i + j) / 2;
            if(!isBadVersion(mid)) i = mid + 1;
            else j = mid;
        }
        return i;
    }
}
