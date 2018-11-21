package Project_Euler;

public class No4LargestPalindrome {

    private static boolean isPalindrome(int a){
        String b = Integer.toString(a);
        for(int i = 0; i < b.length() / 2; i++){
            if(b.charAt(i) != b.charAt(b.length() - i - 1))
                return false;
        }return true;
    }
    private static boolean has2FactorWith3Digits(int a){
        for(int i =100; i <1000; i++ ){
            if(a % i == 0 && Integer.toString(a / i).length() == 3)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int i = 1000000;
        while(!(isPalindrome(i) && has2FactorWith3Digits(i))){
            i--;
        }
        System.out.println(i);
    }
}
