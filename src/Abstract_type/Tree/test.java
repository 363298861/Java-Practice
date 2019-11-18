package Abstract_type.Tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {
    public int method(int a, int b, int c){
        if(a > 0){
            throw new IllegalArgumentException();
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
    public void testMethod(){
        assertEquals(4, method(1, 0, 1));
        assertEquals(2, method(-2, 2, 2));
    }
}
