package Leetcode;

import java.util.*;

public class No207CourseSchedule {
    boolean cycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] marked = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!cycle){
                dfs(i, prerequisites, marked, onStack);
            }
        }
        return !cycle;
    }

    private void dfs(int v, int[][] prerequisites, boolean[] marked, boolean[] onStack){
        if(cycle) return;
        marked[v] = true;
        onStack[v] = true;
        for(int i = 0; i < prerequisites.length; i++){
            if(prerequisites[i][0] == v){
                int w = prerequisites[i][1];
                if(!marked[w]){
                    dfs(w, prerequisites, marked, onStack);
                }else if(onStack[w]){
                    cycle = true;
                }
            }
        }
        onStack[v] = false;
    }

    public boolean canFinishBFS(int numCourses, int[][] prerequisites){
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            inDegree[prerequisites[i][1]]++;
        }

        for(int i = 0; i < numCourses; i++){
            int j = 0;
            for(j = 0; j < numCourses; j++){
                if(inDegree[j] == 0) break;
            }
            if(j == numCourses)
                return false;
            inDegree[j]--;
            for(int k = 0; k < prerequisites.length; k++){
                if(prerequisites[k][0] == j)
                    inDegree[prerequisites[k][1]]--;
            }
        }
        return true;
    }
}







