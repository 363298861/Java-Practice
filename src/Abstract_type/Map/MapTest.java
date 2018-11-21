package Abstract_type.Map;

import java.util.HashSet;

import static org.junit.Assert.assertTrue;

public class MapTest {

    @org.junit.Test
    public void testPut(){
        Map<String, Integer> set = new HashMap<>();
        assertTrue(set.size() == 0);
        set.put("huang", 26);
        assertTrue(set.size() == 1);
        System.out.println(set);
        assertTrue(set.toString().equals("(huang, 26)"));
        set.put("ling", 25);
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("(huang, 26), (ling, 25)") || set.toString().equals("(ling, 25), (huang, 26)"));
        set.put("huang", 26);
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("(huang, 26), (ling, 25)") || set.toString().equals("(ling, 25), (huang, 26)"));
    }

    @org.junit.Test
    public void testRemove(){
        Map<String, Integer> set = new HashMap<>();
        set.put("huang", 26);
        set.put("ling", 26);
        set.put("Ying", 25);
        assertTrue(set.size() == 3);
        set.remove("Ying");
        assertTrue(set.size() == 2);
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("(huang, 26), (ling, 26)") || set.toString().equals("(ling, 26), (huang, 26)"));
        set.remove("ling");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("huang, 26"));
        set.remove("huang");
        assertTrue(set.size() == 0);
    }

    @org.junit.Test
    public void testGet() {
        Map<String, Integer> set = new HashMap<>();
        set.put("huang", 26);
        set.put("ling", 26);
        set.put("Ying", 25);
        assertTrue(set.get("huang") == 26);
        assertTrue(set.get("ling") == 26);
        assertTrue(set.get("Ying") == 25);
        set.remove("ling");
        assertTrue(set.get("ling") == null);
    }

}
