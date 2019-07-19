package Abstract_type.Tree;

public class Complexity {
    public static void printHello(int n){
        for(int i = 0; i < n; i++)
            System.out.println("Hello");
        if(n > 0) {
            printHello(n / 2);
            printHello(n / 2);
        }

    }

    public static void main(String[] args) {
        printHello(4);
    }
}
