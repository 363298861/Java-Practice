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
}
