package Abstract_type.ArrayList;

import Abstract_type.ArrayList.ArrayList;
import Abstract_type.ArrayList.LinkedList;
import org.junit.Test;


import static junit.framework.TestCase.assertTrue;


public class ListTest {
    private boolean arraylist = false;

    @Test
    public void testAdd(){
        List<String> l = arraylist ? new ArrayList<>() : new LinkedList<>();
        assertTrue(l.size() == 0);
        l.add("a");
        assertTrue(l.toString().equals("a"));
        l.add("zhiyuan");
        assertTrue(l.toString().equals("a zhiyuan"));
        l.add("huang");
        assertTrue(l.toString().equals("a zhiyuan huang"));
    }

    @Test
    public void testRemove(){
        List<String> l = arraylist ? new ArrayList<>() : new LinkedList<>();
        assertTrue(l.size() == 0);
        l.add("a");
        l.add("zhiyuan");
        l.add("huang");
        assertTrue(l.toString().equals("a zhiyuan huang"));
        l.remove(2);
        assertTrue(l.toString().equals("a zhiyuan"));
        l.remove(1);
        assertTrue(l.toString().equals("a"));
        l.remove(0);
        assertTrue(l.size() == 0);
    }

    @Test
    public void testGet(){
        List<String> l = arraylist ? new ArrayList<>() : new LinkedList<>();
        assertTrue(l.size() == 0);
        l.add("a");
        l.add("zhiyuan");
        l.add("huang");
        assertTrue(l.toString().equals("a zhiyuan huang"));
        assertTrue(l.get(0).equals("a"));
        assertTrue(l.get(1).equals("zhiyuan"));
        assertTrue(l.get(2).equals("huang"));
    }

    @Test
    public void testReverse(){
        List<String> l = arraylist ? new ArrayList<>() : new LinkedList<>();
        assertTrue(l.size() == 0);
        l.add("a");
        l.add("zhiyuan");
        l.add("huang");
        assertTrue(l.toString().equals("a zhiyuan huang"));
        l.reverse();
        assertTrue(l.toString().equals("huang zhiyuan a"));
    }



}
