package lab;

public class Tokenizer {
    String buffer;
    public boolean hasNext;

    public Tokenizer(String buffer){
        this.buffer = buffer;
        this.hasNext = !buffer.isEmpty();
    }

    public Token takeNext(){
        if(buffer.isEmpty()){
            hasNext = false;
            return null;
        }
        char firstChar = buffer.charAt(0);
        if(firstChar == 'U'){
            String n = "";
            int length = 0;
            for(int i = 2; i < buffer.length(); i++){
                if(Character.isDigit(buffer.charAt(i))){
                    n += buffer.charAt(i);
                }else{
                    length = i;
                    break;
                }
            }
            buffer = buffer.substring(length + 1);
            return new Token("UP", Integer.parseInt(n), Token.Type.MOVE);
        }else if(firstChar == 'D'){
            String n = "";
            int length = 0;
            for(int i = 4; i < buffer.length(); i++){
                if(Character.isDigit(buffer.charAt(i))){
                    n += buffer.charAt(i);
                }else{
                    length = i;
                    break;
                }
            }
            buffer = buffer.substring(length + 1);
            return new Token("DOWN", Integer.parseInt(n), Token.Type.MOVE);
        }else if(firstChar == 'T'){
            String n = "";
            int length = 0;
            for(int i = 4; i < buffer.length(); i++){
                if(Character.isDigit(buffer.charAt(i))){
                    n += buffer.charAt(i);
                }else{
                    length = i;
                    break;
                }
            }
            buffer = buffer.substring(length + 1);
            return new Token("TURN", Integer.parseInt(n), Token.Type.TURN);
        }else if(firstChar == 'R'){
            buffer = buffer.substring(7);
            return new Token(Token.Type.RECORD);
        }
        return null;
    }
}
