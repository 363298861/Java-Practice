package Java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class recursion {

    public List<Integer> sort(List<Integer> unsorted){
        if(unsorted.size() <= 1)
            return unsorted;

        ArrayList<Integer> result = new ArrayList<>();

        List<Integer> unsortedLeft = unsorted.subList(0, unsorted.size()/ 2);
        List<Integer> unsortedRight = unsorted.subList( unsorted.size()/ 2, unsorted.size());

        List<Integer> sortedLeft = sort(unsortedLeft);
        List<Integer> sortedRight = sort(unsortedRight);

        int l = 0;
        int r = 0;
        while(l < sortedLeft.size() || r < sortedRight.size()){
            if( l < sortedLeft.size() &&  (r == sortedRight.size() || sortedLeft.get(l) <= sortedRight.get(r))) {
                result.add(sortedLeft.get(l));
                l++;
            }else{
                result.add(sortedRight.get(r));
                r++;
            }
        }
        return result;
    }

    @Test
    public void testSort(){
        Integer[] a = {7};
        Integer[] b = {3, 6, 32, 5, 2, 80, 99, 21};
        Integer[] c = {2, 3, 5, 6,21, 32, 80,99};


        assertTrue(Arrays.asList(a).equals(sort(Arrays.asList(a))));
        assertTrue(Arrays.asList(c).equals(sort(Arrays.asList(b))));

    }



}
