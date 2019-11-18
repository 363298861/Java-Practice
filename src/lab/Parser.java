package lab;

public class Parser {
    Tokenizer tokenizer;
    Grid grid;

    public Parser(Grid grid, Tokenizer tokenizer){
        this.grid = grid;
        this.tokenizer = tokenizer;
    }

    public void parser(){
        Pointer p = grid.pointer;
        Direction[] d = {Direction.North, Direction.East, Direction.South, Direction.West};
        while(tokenizer.hasNext){
            Token t = tokenizer.takeNext();
            if(t == null)
                return;
            if(t.type == Token.Type.MOVE){
                if(p.direction == Direction.North){
                    if(t.action.equals("UP")){
                        p.x = p.x - t.value;
                        if(grid.record){
                            for(int i = p.x; i < p.x + t.value; i++){
                                grid.addTrace(i, p.y);
                            }
                        }
                    }else{
                        p.x = p.x + t.value;
                        if(grid.record){
                            for(int i = p.x; i < p.x - t.value; i++){
                                grid.addTrace(i, p.y);
                            }
                        }
                    }
                }else if (p.direction == Direction.South){
                    if(t.action.equals("UP")){
                        p.x = p.x + t.value;
                        if(grid.record){
                            for(int i = p.x - t.value; i < p.x ; i++){
                                grid.addTrace(i, p.y);
                            }
                        }
                    }else{
                        p.x = p.x - t.value;
                        if(grid.record){
                            for(int i = p.x; i < p.x + t.value; i++){
                                grid.addTrace(i, p.y);
                            }
                        }
                    }
                }else if (p.direction == Direction.East){
                    if(t.action.equals("UP")){
                        p.y = p.y + t.value;
                        if(grid.record){
                            for(int i = p.y; i < p.y - t.value; i++){
                                grid.addTrace(p.x, i);
                            }
                        }
                    }else{
                        p.y = p.y - t.value;
                        if(grid.record){
                            for(int i = p.y; i < p.y + t.value; i++){
                                grid.addTrace(p.x, i);
                            }
                        }
                    }
                }else if (p.direction == Direction.West){
                    if(t.action.equals("UP")){
                        p.y = p.y - t.value;
                        if(grid.record){
                            for(int i = p.y; i < p.y + t.value; i++){
                                grid.addTrace(p.x, i);
                            }
                        }
                    }else{
                        p.y = p.y + t.value;
                        if(grid.record){
                            for(int i = p.y; i < p.y - t.value; i++){
                                grid.addTrace(p.x, i);
                            }
                        }
                    }
                }
            }else if(t.type == Token.Type.TURN){
                int n = 0;
                while(d[n] != p.direction)
                    n++;
                p.direction = d[(n + t.value / 90) % 4];
            }else if(t.type == Token.Type.RECORD){
                grid.record = !grid.record;
            }
        }
    }
}
