package Btree;

public class SpitRes<K extends Comparable<K>, V> {
    KeyAndValue <K, V> keyvalue;
    BtreeNode<K, V> left;
    BtreeNode<K, V> right;

    public SpitRes() {

    }

    public SpitRes(KeyAndValue <K, V> keyvalue, BtreeNode <K, V> left, BtreeNode <K, V> right) {
        this.keyvalue = keyvalue;
        this.left = left;
        this.right = right;
    }

}
