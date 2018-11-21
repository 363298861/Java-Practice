package Abstract_type.List;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ListTest {
    boolean x = true;
    @Test
    public void testAdd(){
        List<String> l = x ? new ArrayList<String>() : new LinkedList<String>();
        assertTrue(l.size() == 0);
        l.add("a");
        assertTrue(l.size() == 1);
        l.add("bb");
        assertTrue(l.size() == 2);
        l.add("ccc");
        assertTrue(l.size() == 3);
        assertTrue(l.toString().equals("a bb ccc"));
    }

    @Test
    public void testRemove() {
        List<String> l = x ? new ArrayList<String>() : new LinkedList<String>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue(l.size() == 3);
        assertTrue(l.toString().equals("a bb ccc"));
        l.remove(1);
        assertTrue(l.size() == 2);
        assertTrue(l.toString().equals("a ccc"));
        l.remove(1);
        assertTrue(l.size() == 1);
        assertTrue(l.toString().equals("a"));
        l.remove(0);
        assertTrue(l.size() == 0);
    }

    @Test
    public void testGet() {
        List<String> l = x ? new ArrayList<String>() : new LinkedList<String>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue(l.size() == 3);
        assertTrue(l.get(0).equals("a"));
        assertTrue(l.get(1).equals("bb"));
        assertTrue(l.get(2).equals("ccc"));
    }

    @Test
    public void testReverse() {
        List<String> l = x ? new ArrayList<String>() : new LinkedList<String>();
        l.add("a");
        l.add("bb");
        l.add("ccc");
        assertTrue(l.size() == 3);
        assertTrue(l.toString().equals("a bb ccc"));
        l.reverse();
        assertTrue(l.size() == 3);
        assertTrue(l.toString().equals("ccc bb a"));
        l.reverse();
        assertTrue(l.size() == 3);
        assertTrue(l.toString().equals("a bb ccc"));
        l.add("dddd");
        assertTrue(l.size() == 4);
        assertTrue(l.toString().equals("a bb ccc dddd"));
        l.reverse();
        assertTrue(l.size() == 4);
        assertTrue(l.toString().equals("dddd ccc bb a"));
        l.reverse();
        assertTrue(l.size() == 4);
        assertTrue(l.toString().equals("a bb ccc dddd"));

    }

}
