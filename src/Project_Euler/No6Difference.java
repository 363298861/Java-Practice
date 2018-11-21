package Project_Euler;

public class No6Difference {
    public static void main(String[] args) {
        long sum = 0;
        for(int i = 1; i < 101; i++){
            sum += i * i;
        }
        System.out.println(sum - 5050 * 5050);
    }
}
