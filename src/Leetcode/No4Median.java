package Leetcode;


import java.util.ArrayList;
import java.util.Collections;

public class No4Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i : nums1)
            a.add(i);
        for(int j : nums2)
            a.add(j);
        int l = a.size();

        Collections.sort(a);
        if(l == 1)
            return a.get(0);
        return l % 2 != 0 ? a.get(l / 2) * 1.0 : ((a.get(l / 2 - 1) + a.get(l / 2)) * 1.0) / 2;
    }
}
