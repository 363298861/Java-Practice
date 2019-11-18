package lab;

public class Token {

    int value;
    Type type;
    String action;

    public enum Type{
        MOVE, TURN, RECORD,
    }

    public Token(String action, int value, Type type){
        this.value = value;
        this.type = type;
        this.action = action;
    }

    public Token(Type type){
        this.type = type;
    }

}
