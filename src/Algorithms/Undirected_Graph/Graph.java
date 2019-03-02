package Algorithms.Undirected_Graph;

import edu.princeton.cs.algs4.Stack;

import java.util.List;


public class Graph {

    private int v;
    private int e;
    private Stack<Integer>[] adj;

    Graph(int v){
        this.v = v;
        this.e = 0;
        adj =  new Stack[v];
        for(int i = 0; i < v; i++)
            adj[i] = new Stack();
    }

    void addEdge(int v, int w){
        if(v < this.v || w < this.v)
            throw new IllegalArgumentException("Invalid input");
        adj[v].push(w);
        adj[w].push(v);
        e++;
    }

    Iterable<Integer> adj(int v){
        return adj[v];
    }

    int V(){
        return v;
    }

    int E(){
        return e;
    }

    @Override
    public String toString(){
        return "";
    }

}
