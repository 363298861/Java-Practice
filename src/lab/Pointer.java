package lab;

public class Pointer {
    int x;
    int y;
    Direction direction;

    public Pointer(int x, int y, Direction direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString(){
        return direction.toString();
    }
}
