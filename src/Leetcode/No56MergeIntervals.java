package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int l = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < l; i++){
            if(i < l - 1 && intervals[i][1] < intervals[i + 1][0]){
                res.add(intervals[i]);
            }else{
                int j = 0;
                int tmp = intervals[i + j][1];
                while(i + j + 1 < l && tmp >= intervals[i + j + 1][0]) {
                    tmp = Math.max(tmp, intervals[i + j + 1][1]);
                    j++;
                }
                res.add(new int[] {intervals[i][0], tmp});
                i += j;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = {{2, 3}, {4, 5}, {7, 8}, {1, 10}};
        int[][] b = {{1,4}, {2, 3}};
        No56MergeIntervals t = new No56MergeIntervals();
        int[][] r = t.merge(a);
        for(int[] row : r){
            for(int i : row)
                System.out.print(i);
            System.out.println();
        }
    }
}
