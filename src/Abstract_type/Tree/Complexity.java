package Abstract_type.Tree;

public class Complexity {
    public static void printHello(int n, int m){
        if(n < 0){
            throw new IllegalArgumentException();
        }
        if(n == 0){
            System.out.println(n);
        }else{
            System.out.println(n);
            if(m < 5)
                System.out.println(m);
        }
    }



    public static void main(String[] args) {
        printHello(4, 4);
    }
}
