package OOP;

public class Circular extends SteelPlate {
    public Circular(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    double area(){
        return Math.PI * 0.25;
    }
}
