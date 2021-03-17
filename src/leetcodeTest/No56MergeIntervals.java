package leetcodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No56MergeIntervals {

    public class intervalCmp implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new intervalCmp());
        int lo = intervals[0][0];
        int hi = intervals[0][1];
        if( intervals.length == 1)
            res.add(new int[] {lo, hi});
        for(int i = 1; i < intervals.length; i++){
            if(hi >= intervals[i][0]){
                hi = Math.max(hi, intervals[i][1]);
            }else{
                res.add(new int[] {lo, hi});
                lo = intervals[i][0];
                hi = Math.max(hi, intervals[i][1]);
            }
            if(i == intervals.length - 1)
                res.add(new int[] {lo, hi});
        }
        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        No56MergeIntervals n = new No56MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = n.merge(intervals);
        for(int[] row : res) {
            for (int j : row) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
