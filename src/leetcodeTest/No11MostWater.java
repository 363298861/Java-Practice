package leetcodeTest;

public class No11MostWater {
    public int maxArea(int[] height) {
        int res = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                if(j < height.length - 1 && height[j] <= height[j + 1])
                    continue;
                res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return res;
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

    public static void main(String[] args) {
        No11MostWater n = new No11MostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,3,2,5,25,24,5};
        System.out.println(n.binarySearch(height));
    }
}
