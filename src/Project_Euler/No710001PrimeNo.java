package Project_Euler;

public class No710001PrimeNo {
    public static void main(String[] args) {
        int count = 1; long i = 3;
        while (count < 10001){
            if(isPrime(i)) {
                count++;
            }
           i++;
        }
        System.out.println(i - 1);
        long sum = 2;
        for(long j = 3; j < 2000000; j++){
            if(isPrime(j)){
                sum += j;
            }
        }
        System.out.println(sum);
    }

    private static boolean isPrime(long a){
        for(long i = 2; i < a; i++){
            if(a % i == 0)
                return false;
        }
        return true;
    }
}
