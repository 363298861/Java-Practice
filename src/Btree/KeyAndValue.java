package Btree;

public class KeyAndValue<K, V> {
    K key;
    V value;

    public KeyAndValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public String show() {
        return key.toString() + "=>" + value.toString();
    }

}

