package Algorithms_Princeton.Digraph;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Stack;

public class Digraph {
    private int v;
    private int e;
    private Bag<Integer>[] adj;

    Digraph(int v){
        this.v = v;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for(int i = 0; i < v; i++)
            adj[i] = new Bag<>();
    }

    void addEdge(int v, int w){
        adj[v].add(w);
        e++;
    }

    Iterable<Integer> adj(int v){
        return adj[v];
    }

    int V(){
        return v;
    }

    int E(){ return e;}


}
