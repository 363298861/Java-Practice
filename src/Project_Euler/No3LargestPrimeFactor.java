package Project_Euler;

public class No3LargestPrimeFactor {
    public static void main(String[] args) {
        long factor = 2; long lastfactor = 1;
        long n = 600851475143L;
        while( n > 1){
            if(n % factor == 0){
                lastfactor = factor;
                n = n/factor;
                while(n % factor == 0){
                    n = n / factor;
                }
            }
            factor ++;
        }

        System.out.println(lastfactor);

    }
}
