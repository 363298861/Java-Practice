package Btree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrStrTableTest {
    private Table<String, String> table;

    @Before
    public void constructBtreeTable() {
        table = new BtreeNode<String, String>();
        table.insert("Batman", "Batcave");
        table.insert("Catwoman", "Gotham");
        table.insert("Sherlock", "221b Baker St");
        table.insert("DrWho", "TARDIS");
        table.insert("Robin", "Batcave");
        table.insert("Wonderwoman", "Themyscira Island");
        table.insert("Thor", "Asgar");
        table.insert("Superman", "Northpole");
        table.insert("BlackWidow","Russia");
        table.insert("BlackAdder","Britian");

    }

    @Test
    public void testThor() {
        assertEquals("Asgar", table.lookup("Thor"));
    }

    @Test
    public void testBlackWidow() {
        assertEquals("Russia", table.lookup("BlackWidow"));
    }



}
