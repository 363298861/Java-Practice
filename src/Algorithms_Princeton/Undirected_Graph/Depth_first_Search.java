package Algorithms_Princeton.Undirected_Graph;

public class Depth_first_Search {

    private boolean[] marked;
    private int[] edgeTo;
    private int c;

    Depth_first_Search(Graph G, int s){
        search(G, s);
    }

    private void search(Graph g, int s){
        marked[s] = true;
        for(int n : g.adj(s)){
            if(!marked[n]){
                search(g, n);
                edgeTo[n] = s;
            }
        }
    }

    boolean marked(int v){
        return marked[v];
    }

    int count(){
        for(int i = 0; i < marked.length; i++){
            if(marked[i])
                c++;
        }
        return c - 1;
    }

}
