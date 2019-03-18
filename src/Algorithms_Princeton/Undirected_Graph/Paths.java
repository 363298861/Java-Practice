package Algorithms_Princeton.Undirected_Graph;

public class Paths {

    private int s;
    private Graph g;
    private

    Paths(Graph G, int s){
        g = G;
        this.s = s;
    }



    boolean hasPathTo(int v){
        if(v > g.V() || v < 0)
            throw new IllegalArgumentException();
        return false;
    }

    Iterable<Integer> pathTo(int v){
        return null;
    }
}
