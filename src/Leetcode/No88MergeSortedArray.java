package Leetcode;

public class No88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = m - 1, l2 = n - 1, p = m + n - 1;
        while(p >= 0){
            if(l1 < 0){
                nums1[p--] = nums2[l2--];
            }else if(l2 < 0){
                nums1[p--] = nums1[l1--];
            } else if(nums1[l1] > nums2[l2]){
                nums1[p--] = nums1[l1--];
            }else{
                nums1[p--] = nums2[l2--];
            }
        }
    }
}
