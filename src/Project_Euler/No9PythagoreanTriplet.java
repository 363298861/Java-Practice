package Project_Euler;

public class No9PythagoreanTriplet {
    public static void main(String[] args) {
        System.out.println(iNumber());
        System.out.print(200 * 375 * 425);
    }
    private static int iNumber(){
        for(int i = 1; i < 1000; i++){
            for(int j = 1; j < 1000; j++){
                if(i * i + j * j == (1000 - i - j) * (1000 - j - i))
                    return j;
            }
        }
        return 0;
    }
}
