package lab;

public class GridTest {
    public static void main(String[] args) {
        Grid grid = new Grid(11, 11, new Pointer(5, 5, Direction.North));
        System.out.println(grid.show());
        System.out.println();
        Tokenizer t = new Tokenizer("UP3;RECORD;TRUN90;DOWN3;TURN90;UP5;");
        Parser parser = new Parser(grid, t);
        parser.parser();
        System.out.println(grid.show());
    }
}
