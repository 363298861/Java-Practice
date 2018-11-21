package Abstract_type.Map;

import java.util.LinkedList;

public class HashMap<K, V> implements Map<K, V> {
    final static int SIZE = 2;
    LinkedList<KVpair>[] table = new LinkedList[SIZE];
    int elements = 0;

    private int hash(K key){
        return Math.abs(key.hashCode() % 2);
    }

    class KVpair {
        K key; V value;
        KVpair(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "(" + key + ", " + value + ")";
        }
    }

    KVpair find(LinkedList<KVpair> ll, K key){
        for(KVpair kv : ll){
            if(kv.key.equals(key))
                return kv;
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int a = hash(key);
        if(table[a] == null)
            table[a] = new LinkedList<>();
        LinkedList<KVpair> ll = table[a];
        KVpair kv = find(ll, key);
        if(kv == null) {
            ll.add(new KVpair(key, value));
            elements++;
        }else {
            kv.value = value;
        }

    }

    @Override
    public void remove(K key) {
        int a = hash(key);
        LinkedList<KVpair> ll = table[a];
        if(ll != null){
            KVpair kv = find(ll, key);
            if(kv != null) {
                ll.remove(key);
                elements--;
            }
        }
    }

    @Override
    public V get(K key) {
        int a = hash(key);
        LinkedList<KVpair> b = table[a];
        if(b != null){
            KVpair kv = find(b, key);
            if(kv != null)
                return kv.value;
            else
                return null;
        }
        return null;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString(){
        String rtn = "";
        for(int i = 0; i < table.length; i++){
            LinkedList<KVpair> ll = table[i];
            if(ll != null){
                for(KVpair b : ll){
                    if(!rtn.equals(""))
                        rtn += ", ";
                    rtn += b.toString();
                }
            }
        }
        return rtn;
    }
}
