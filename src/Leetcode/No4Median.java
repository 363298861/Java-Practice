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

    public double findMedianSortedArraysModified(int[] nums1, int[] nums2){
        int l1 = nums1.length, l2 = nums2.length;
        if(l2 > l1) return findMedianSortedArraysModified(nums2, nums1);

        int lo = 0, hi = 2 * l2;
        while(lo <= hi){
            int m2 = (lo + hi) / 2;
            int m1 = l1 + l2 - m2;
            double left2 = m2 == 0 ? Double.NEGATIVE_INFINITY : nums2[(m2 - 1) / 2];
            double right2 = m2 == 2 * l2 ? Double.POSITIVE_INFINITY : nums2[m2 / 2];
            double left1 = m1 == 0 ? Double.NEGATIVE_INFINITY : nums1[(m1 - 1) / 2];
            double right1 = m1 == 2 * l1 ? Double.POSITIVE_INFINITY : nums1[m1 / 2];

            if(right1 < left2) hi = m2 - 1;
            else if(right2 < left1) lo = m2 + 1;
            else return (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] n1 = {6, 7, 8, 9 ,10, 11};
        int[] n2 = {3, 4, 5, 6};
        No4Median n = new No4Median();
        System.out.println(n.findMedianSortedArraysModified(n1, n2));
    }
}
