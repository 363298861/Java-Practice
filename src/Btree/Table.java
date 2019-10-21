package Btree;

public interface Table<K extends Comparable<K>, V> {
    V lookup(K id);
    void insert(K id, V name);
}

