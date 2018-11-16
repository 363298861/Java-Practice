package Java;

public class Exception extends Throwable {

    private static void aaa(){
        System.out.println("Start method");

        try{
            int i = 9 / 0 ;
            String d = null;
            System.out.println(d.toString());
        } catch (IndexOutOfBoundsException p){
            System.out.println("get an error: "+ p);
        } catch (java.lang.Exception i) {
            System.out.println("get an error: "+ i );
        }finally {
            System.out.println("Execute anyway!");
        }

        System.out.println("End of method");
    }

    public static void main(String[] args) {
        System.out.println("Start of main method:");
        aaa();
        System.out.println("End of main method:");
    }
}
