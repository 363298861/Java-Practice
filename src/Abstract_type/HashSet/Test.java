package Abstract_type.HashSet;

import java.util.HashSet;

import static org.junit.Assert.assertTrue;

public class Test {

    @org.junit.Test
    public void testAdd(){
        HashSet<String> set = new HashSet<>();
        assertTrue(set.size() == 0);
        set.add("huang");
        assertTrue(set.size() == 1);
        System.out.println(set);
        assertTrue(set.toString().equals("huang"));
        set.add("Huang");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Huang"));
        set.add("Zhiyuan");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Huang, Zhiyuan") || set.toString().equals("Zhiyuan, Huang"));
        set.add("Zhiyuan");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Huang, Zhiyuan") || set.toString().equals("Zhiyuan, Huang"));

    }

    @org.junit.Test
    public void testRemove(){
        HashSet<String> set = new HashSet<>();
        set.add("huang");
        set.add("Zhiyuan");
        set.add("Ying");
        assertTrue(set.size() == 3);
        set.remove("Ying");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("huang, Zhiyuan") || set.toString().equals("Zhiyuan, huang"));
        set.remove("Ling");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("huang, Zhiyuan") || set.toString().equals("Zhiyuan, huang"));
        set.remove("huang");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Zhiyuan"));
    }

    @org.junit.Test
    public void testContains() {
        HashSet<String> set = new HashSet<>();
        set.add("huang");
        set.add("Zhiyuan");
        set.add("Ying");
        assertTrue(set.contains("huang"));
        assertTrue(set.contains("Zhiyuan"));
        assertTrue(!set.contains("Ling"));
        set.remove("Ying");
        assertTrue(!set.contains("Ying"));
    }
}
