package Leetcode;

public class No84LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int min = heights[i];
            for(int j = i; j < heights.length; j++){
                min = Math.min(min, heights[j]);
                max = Math.max(max, (j - i + 1) * min);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] h = {2, 1, 5, 6, 2, 3};
        No84LargestRectangle n = new No84LargestRectangle();
        System.out.println(n.largestRectangleArea(h));
    }
}
