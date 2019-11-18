package lab;

public enum Direction {
    North, South, East, West;

    public String toString(){
        if(this == North)
            return "^";
        if(this == South)
            return "v";
        if(this == East)
            return "<";
        return ">";
    }
}
