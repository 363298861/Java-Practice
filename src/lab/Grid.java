package lab;

public class Grid {
    int x, y;
    Pointer pointer;
    boolean record;
    boolean[][] trace;

    public Grid(int x, int y, Pointer pointer){
        this.x = x;
        this.y = y;
        this.pointer = pointer;
        record = false;
        trace = new boolean[x][y];
    }

    public void addTrace(int x, int y){
        trace[x][y] = true;
    }

    public String show(){
        String res = "";

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(i != pointer.x || j != pointer.y){
                    if(trace[i][j])
                        res += "$ ";
                    else
                        res += "# ";
                }else
                    res += pointer.toString() + " ";
            }
            res += "\n";
        }
        return res;
    }

    public static void main(String[] args) {
        Grid grid = new Grid(11, 11, new Pointer(5, 5, Direction.North));
        System.out.println(grid.show());
    }
}
