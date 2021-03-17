package Leetcode;

public class No11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length - 1; i++){
            for(int j = i + 1; j < height.length; j++){
                max = max < Math.min(height[i], height[j]) * (j - i) ? Math.min(height[i], height[j]) * (j - i) : max;
            }
        }
        return max;
    }

    public int binarySearch(int[] height){
        int lo = 0, hi = height.length - 1;
        int res = 0;
        while(lo < hi){
            res = Math.max(res, (hi - lo) * Math.min(height[hi], height[lo]));
            if(height[lo] <= height[hi]){
                lo++;
            }else{
                hi--;
            }
        }
        return res;
    }
}
