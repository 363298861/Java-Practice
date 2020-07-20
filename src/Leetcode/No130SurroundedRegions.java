package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class No130SurroundedRegions {

    public static class QuickFindUF{
        int[] id;

        public QuickFindUF(int N){
            id = new int[N];
            for(int i = 0; i < N; i++){
                id[i] = i;
            }
        }

        void union(int p, int q){
            if(connected(p, q)) return;
            int t = id[p];
            for(int i = 0; i < id.length; i++){
                if(id[i] == t){
                    id[i] = id[q];
                }
            }
        }

        boolean connected(int p, int q){
            return id[p] == id[q];
        }

        public String toString(){
            String res = "";
            for(int i = 0; i < id.length; i++){
                res += id[i] + " ";
            }
            return res;
        }
    }

    public static class QuickUnionUF{
        int[] id;
        int[] elem;

        public QuickUnionUF(int N){
            id = new int[N];
            elem = new int[N];
            for(int i = 0; i < N; i++){
                id[i] = i;
                elem[i] = 0;
            }
        }

        void union(int p, int q){
            int pelem = find(p), qelem = find(q);
            if(pelem == qelem) return;
            if(elem[pelem] > elem[qelem]){
                id[qelem] = pelem;
                elem[pelem] += elem[qelem];
            }else{
                id[pelem] = qelem;
                elem[qelem] += elem[pelem];
            }
        }

        int find(int p){
            while(id[p] != p){
                id[p] = id[id[p]]; //path compression very important!!!
                p = id[p];
            }
            return p;
        }

        boolean connected(int p, int q){

            return find(p) == find(q);
        }

        int count(){
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < id.length; i++){
                set.add(find(i));
            }
            return set.size();
        }

        public String toString(){
            String res = "";
            for(int i = 0; i < id.length; i++){
                res += id[i] + " ";
            }
            return res;
        }
    }


    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0) return;
        int col = board[0].length;
        if(col == 0) return;
        QuickUnionUF uf = new QuickUnionUF(row * col + 1);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 || j == 0 || i == row - 1 || j == col - 1){
                    if(board[i][j] == 'O'){
                        uf.union(i * col + j, row * col);
                    }
                }else{
                    if(board[i][j] == 'O'){
                        if(board[i - 1][j] == 'O')
                            uf.union(i * col + j, (i - 1) * col + j);
                        if(board[i + 1][j] == 'O')
                            uf.union(i * col + j, (i + 1) * col + j);
                        if(board[i][j - 1] == 'O')
                            uf.union(i * col + j, i * col + j - 1);
                        if(board[i][j + 1] == 'O')
                            uf.union(i * col + j, i * col + j + 1);
                    }
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O' && !uf.connected(i * col + j, row * col))
                    board[i][j] = 'X';
            }
        }
    }
    // Question 200: Number of Islands
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row == 0) return 0;
        int col = grid[0].length;
        if(col == 0) return 0;
        QuickUnionUF uf = new QuickUnionUF(row * col + 1);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '0') uf.union(i * col + j, row * col);
                else{
                    if(i > 0 && grid[i - 1][j] == '1')
                        uf.union(i * col + j, (i - 1) * col + j);
                    if(i < row - 1 && grid[i + 1][j] == '1')
                        uf.union(i * col + j, (i + 1) * col + j);
                    if(j > 0 && grid[i][j - 1] == '1')
                        uf.union(i * col + j, i * col + j - 1);
                    if(j < col - 1 && grid[i][j + 1] == '1')
                        uf.union(i * col + j, i * col + j + 1);
                }
            }
        }
        return uf.count() - 1;
    }

    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(5);
        System.out.println(uf);
        System.out.println(uf.count());
        uf.union(1, 3);
        uf.union(2, 4);
        System.out.println(uf);
        System.out.println(uf.count());
        uf.union(1, 0);
        System.out.println(uf);
        System.out.println(uf.connected(0, 1));
        System.out.println(uf.connected(0, 3));
        System.out.println(uf.connected(0, 2));
        System.out.println(uf.count());
    }
}
