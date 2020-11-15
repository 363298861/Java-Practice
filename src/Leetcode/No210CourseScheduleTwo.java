package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No210CourseScheduleTwo {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
        }
        int[] res = new int[numCourses];
        int l = 0;
        while(l < numCourses) {
            boolean zeroExist = false;
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    zeroExist = true;
                    res[l] = i;
                    l++;
                    inDegree[i]--;
                    for (int[] prerequisite : prerequisites) {
                        if (prerequisite[1] == i)
                            inDegree[prerequisite[0]]--;
                    }
                }
            }
            if(!zeroExist) return new int[] {};
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] prerequisite = {{1, 0}, {2, 0}, {3, 0}, {4, 1}, {2, 4}, {5, 2}, {5, 3}};
        int[][] prerequisite2 = {{1, 0}};
        int[][] prerequisite3 = {};
        No210CourseScheduleTwo n = new No210CourseScheduleTwo();
        for(int i : n.findOrder(1, prerequisite3))
            System.out.println(i);
    }
}
