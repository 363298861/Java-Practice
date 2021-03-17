package Leetcode;

public class No263UglyNumber {
    public boolean isUgly(int num) {
        while(num % 2 == 0 || num % 3 == 0 || num % 5 == 0){
            if(num % 2 == 0)
                num /= 2;
            else if(num % 3 == 0)
                num /= 3;
            else if(num % 5 == 0)
                num /= 5;
        }
        return num == 1;
    }

    public static void main(String[] args) {

    }
}
