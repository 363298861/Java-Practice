package Btree;

import java.util.ArrayList;

public class BtreeNode<K extends Comparable<K>, V> implements Table<K, V>{

    public static final int MAXKEYSPERNODE = 2;

    ArrayList<KeyAndValue<K, V>> keysandvalues;
    ArrayList<BtreeNode<K, V>> children;

    public BtreeNode() {
        keysandvalues = new ArrayList<KeyAndValue<K, V>>();
        children = new ArrayList<BtreeNode<K, V>>();
    }

    @Override
    public V lookup(K key) {
        for (KeyAndValue<K, V> kv : keysandvalues) if (kv.key.equals(key)) return (V) kv.value;
        if (children.size() > 0) {
            for (int i = 0; i <= keysandvalues.size(); i++) {
                if (i== keysandvalues.size() ||
                        key.compareTo(keysandvalues.get(i).key) < 0) {
                    return children.get(i).lookup(key);
                }
            }
        }
        return null;
    }

    @Override
    public void insert(K key, V name) {
        SpitRes<K, V> down = insertDown(key, name);
        if (down != null) {
            keysandvalues.clear();
            children.clear();
            keysandvalues.add(down.keyvalue);
            children.add(down.left);
            children.add(down.right);
        }
    }

    public SpitRes<K, V> insertDown(K key, V name){
        return null;
    }

    public String showTree(int indent) {
        String res = "";
        if (children.size() == 0) {
            res += space(indent) + "[";
            for (int i = 0; i < keysandvalues.size(); i++) {
                res += (i == 0 ? "" : ",") + keysandvalues.get(i).show();
            }
            res += "]\n";
        } else {
            res += space(indent) + "[\n";
            res += children.get(0).showTree(indent + 1);
            for (int i = 0; i < keysandvalues.size(); i++) {
                res += space(indent) + keysandvalues.get(i).show() + "\n";
                res += children.get(i + 1).showTree(indent + 1);
            }
            res += space(indent) + "]\n";
        }
        return res;
    }

    private String space(int indent) {
        String res = "";
        for (int i = 0; i < indent * 3; i++)
            res += " ";
        return res;
    }

    public static void main(String[] args) {
        BtreeNode<String, String> table = new BtreeNode<String, String>();
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
        System.out.println(table.showTree(2));
    }
}
