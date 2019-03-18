package Algorithms_Princeton.Digraph;

import edu.princeton.cs.algs4.Digraph;

public class Depth_first_search {

    private boolean[] marked;
    private int[] edgeTo;
    private int v;

    Depth_first_search(Digraph g, int s){
        marked = new boolean[g.V()];
        DFS(g, s);
    }

    void DFS(Digraph g, int s){
        marked[s] = true;
        for(int n : g.adj(s)){
            if(!marked[n]){
                edgeTo[s] = n;
                DFS(g, n);
            }
        }
    }

}
