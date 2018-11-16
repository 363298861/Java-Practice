package HashMap;

import java.util.LinkedList;

public class HashMap<K, V> implements Map<K, V> {
    static final int Size = 20;
    LinkedList<KVpair>[] table;
    int n;

    HashMap(){
        table = new LinkedList[Size];
    }

    int hash(K key){
        return Math.abs(key.hashCode() % Size);
    }

    class KVpair{
        K key;
        V value;

        KVpair(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "(" +  key + ", " + value + ")";
        }
    }

    KVpair find(LinkedList<KVpair> a, K key){
        for(int i = 0 ; i< a.size(); i++){
            if(a.get(i).key.equals(key)){
                return a.get(i);
            }
        }
        return null;
    }


    @Override
    public void put(K key, V value) {
        int a = hash(key);
        if (table[a] == null) {
            table[a] = new LinkedList<>();
        }
        LinkedList<KVpair> ll = table[a];
        if (find(ll, key) != null) {
            find(ll, key).value = value;
        }else{
            ll.add(new KVpair(key, value));
            n++;
        }
    }

    @Override
    public void remove(K key) {
        int a = hash(key);
        if (table[a] == null) {
            table[a] = new LinkedList<>();
        }
        LinkedList<KVpair> ll = table[a];
        if (find(ll, key) != null) {
            ll.remove(find(ll, key));
            n--;
        }
    }

    @Override
    public V get(K key) {
        int a = hash(key);
        if (table[a] == null || find(table[a], key) == null) {
            return null;
        }else {
            LinkedList<KVpair> ll = table[a];
            return find(ll, key).value;
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public String toString(){
        String r = "";
        if (table != null) {
            for(int i = 0; i< table.length; i++){
                if (table[i] != null) {
                    for(KVpair kv : table[i]){
                        if(r != "")
                            r += ", ";
                        r += kv;
                    }
                }
            }
        }
        return r;
    }

}
