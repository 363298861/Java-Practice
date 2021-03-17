package Leetcode;

public class No42TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        for(int i = 0; i < height.length; i++){
            if(i < height.length - 1 && height[i + 1] < height[i]){
                for(int j = i + 1; j < height.length; j++){
                    if(height[j] >= height[i]) {

                        res += water(height, i, j);
                        i = j - 1;
                        break;
                    }
                    if(j == height.length - 1){

                        j = findMax(height, i + 1);
                        res += water(height, i, j);
                        i = j - 1;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public int water(int[] height, int start, int end){
        int res = 0;
        int h = Math.min(height[start], height[end]);
        for(int i = start + 1; i < end; i++){
            res += h - height[i];
        }
        return res;
    }

    public int findMax(int[] height, int start){
        int idx = -1;
        for(int i = start; i < height.length; i++){
            if(idx == -1 || height[i] > height[idx]){
                idx = i;
            }
        }
        return idx;
    }

    public int binarySearch(int[] height){
        int lo = 0, hi = height.length - 1;
        int res = 0;
        int leftMax = 0, rightMax = 0;
        while(lo <= hi){
            if(height[lo] <= height[hi]) {
                if (height[lo] >= leftMax) {
                    leftMax = height[lo];
                } else {
                    res += leftMax - height[lo];
                }
                lo++;
            }else{
                if(height[hi] >= rightMax){
                    rightMax = height[hi];
                }else{
                    res += rightMax - height[hi];
                }
                hi--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] t1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] t2 = {4,2,0,3,2,5};
        No42TrappingRainWater n = new No42TrappingRainWater();
        System.out.println(n.binarySearch(t1));
    }
}
