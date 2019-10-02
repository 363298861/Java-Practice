package Leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {
    public int testMethod(int a, int b, int c){
        if(a > 0){
            a = 2;
        }else{
            a = -2;
            if(b > 0){
                b = 2;
            }
        }
        if(c > 0){
            c = 2;
        }
        return a + b + c;
    }
    @Test
    public void codeComplete(){
        assertEquals(testMethod(1,1,1), 6);
    }
}
