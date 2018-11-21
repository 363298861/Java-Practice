package Abstract_type.BStree;

import Abstract_type.ArrayList.ArrayList;
import Abstract_type.ArrayList.List;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

public class BStreeTest {

    @Test
    public void testAdd(){
        Set<String> set = new BSTSet<>();
        set.add("Huang");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Huang"));
        set.add("Zhiyuan");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Huang, Zhiyuan") || set.toString().equals("Zhiyuan, Huang"));
    }

    @Test
    public void testRemove(){
        Set<String> l =  new BSTSet<>();
        TestCase.assertTrue(l.size() == 0);
        l.add("a");
        l.add("Zhiyuan");
        l.add("Huang");
        l.remove("a");
        assertTrue(l.size() == 2);
        System.out.println(l);
        assertTrue(l.toString().equals("Huang, Zhiyuan") || l.toString().equals("Zhiyuan, Huang"));
        l.remove("Huang");
        TestCase.assertTrue(l.toString().equals("Zhiyuan"));
        assertTrue(l.size() == 1);
        l.remove("Zhiyuan");
        TestCase.assertTrue(l.size() == 0);
    }

    @Test
    public void testContains(){
        Set<String> l =  new BSTSet<>();
        TestCase.assertTrue(l.size() == 0);
        l.add("a");
        l.add("zhiyuan");
        l.add("huang");
        assertTrue(l.size() == 3);
        assertTrue(l.contains("a") && l.contains("huang") && l.contains("zhiyuan"));
        l.remove("huang");
        assertTrue(l.contains("a") && l.contains("zhiyuan"));
        assertTrue(l.size() == 2);
        l.remove("zhiyuan");
        assertTrue(l.contains("a"));
        TestCase.assertTrue(l.size() == 1);
    }


}
