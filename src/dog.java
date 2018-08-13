
 enum Signal{
    Red, Blue, Yellow
}

public class dog{
    public static void main(String[] args) {
        Signal xin = Signal.Red;
        switch(xin) {
            case Red:
                System.out.println("red");break;
            case Blue:
                System.out.println("Blue");
            case Yellow:
                System.out.println("Yellow");
        }
    }
}