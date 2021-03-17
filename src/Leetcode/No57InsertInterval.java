package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No57InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            int[] itv = intervals[i];
            if(itv[1] < newInterval[0])
                res.add(itv);
            else if(itv[0] > newInterval[1]) {
                res.add(newInterval);
                newInterval = itv;
            }else {
                newInterval[0] = Math.min(newInterval[0], itv[0]);
                newInterval[1] = Math.max(newInterval[1], itv[1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[0][0]);
    }
}
