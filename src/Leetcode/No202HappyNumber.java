package Leetcode;

public class No202HappyNumber {
    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do{
            slow = digitSquare(slow);
            fast = digitSquare(fast);
            fast = digitSquare(fast);
        }while(fast != slow);

        return slow == 1;
    }

    public int digitSquare(int n){
        int res = 0;
        while(n > 0){
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
