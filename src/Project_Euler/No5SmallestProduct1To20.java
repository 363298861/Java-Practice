package Project_Euler;

public class No5SmallestProduct1To20 {
    public static void main(String[] args) {
        int x = smallestProduct(11, 12);
        int[] a = { 11, 12, 13, 14, 15,16 ,17, 18, 19, 20};
        for(int i = 2; i < a.length; i ++){
            x = smallestProduct(x, a[i]);
        }
        System.out.println(x);
        System.out.println(smallestProduct(11,12));
    }


    private static int smallestProduct(int a, int b){
        int s = a * b;
        for(int i = smallNo(a,b); i > 1; i--){
            if(a % i == 0 && b % i == 0) {
                if(s / i >= a && s / i >= b)
                    s = s /i ;
            }
        }
        return s;

    }

    private static int smallNo (int a, int b){
        if(a > b)
            return b;
        else
            return a;
    }
}
