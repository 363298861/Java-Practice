package OOP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sculpture extends SteelPlate{
    List<SteelPlate> list;
    List<Position> neighours;

    public Sculpture(){
         list = new ArrayList<>();
         neighours = new ArrayList<>();
    }

    public void addSteelPlate(SteelPlate steelPlate){
        list.add(steelPlate);
        if(steelPlate instanceof Square){
            neighours.add(new Position(steelPlate.x+1, steelPlate.y));
            neighours.add(new Position(steelPlate.x-1, steelPlate.y));
            neighours.add(new Position(steelPlate.x, steelPlate.y + 1));
            neighours.add(new Position(steelPlate.x, steelPlate.y - 1));
        }
    }

    public double area(){
        double area = 0;
        for(SteelPlate sp : list)
            area += sp.area();
        return area;
    }

    public boolean hasBalance(){
        for(SteelPlate sp : list){
            if(sp instanceof Circular){
                for(Position p : neighours){
                    if(p.x == sp.x && p.y == sp.y){
                        break;
                    }
                    if(p.equals(neighours.get(neighours.size() - 1))){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Sculpture sculpture = new Sculpture();
        sculpture.addSteelPlate(new Circular(2, 2));
        sculpture.addSteelPlate(new Circular(3, 2));
        sculpture.addSteelPlate(new Circular(2, 3));
        sculpture.addSteelPlate(new Square(3, 3));
        sculpture.addSteelPlate(new Square(2,  1));
        System.out.println(sculpture.hasBalance());
    }


}
