package Algorithms_Princeton.Undirected_Graph;


import edu.princeton.cs.algs4.Queue;

public class Breadth_First_Search {

    private int s;
    private int[] edgeTo;
    private int[] distTo;
    private boolean[] marked;
    private Queue<Integer> q;
    private int layer;

    Breadth_First_Search(Graph g, int s){
        this.s = s;
        marked = new boolean[g.V()];
        q = new Queue<>();
        BFS(g, s);
    }

    private void BFS (Graph g, int s) {
        layer++;
        q.enqueue(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int w = q.dequeue();
            for (int n : g.adj(w)) {
                if (!marked[n]) {
                    q.enqueue(n);
                    edgeTo[n] = s;
                    marked[n] = true;
                    distTo[n] = layer;
                }
            }
        }
    }
}
