package JavaExercise1;

public class SumOf100PrimeNumbers {
    public static void main(String[] args) {
        int count = 1; int prime = 2; int sum = 2;
        while(count < 100){
            prime++;
            if(isPrime(prime)){
                sum += prime;
                count++;
            }
        }
        System.out.println(sum);
    }

    private static boolean isPrime(int n){
        for(int j = 2; j < n; j++){
            if(n % j == 0)
                return false;
        }return true;
    }
}
