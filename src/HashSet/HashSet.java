package HashSet;

import java.util.LinkedList;

public class HashSet<T> implements Set<T> {

    static final int Size = 20;
    LinkedList<T>[] table;
    int n;

    HashSet(){
        table = new LinkedList[Size];
    }

    int hash(T value){
        return Math.abs(value.hashCode() % Size);
    }

    @Override
    public void add(T item) {
        int a = hash(item);
        if(table[a] == null)
            table[a] = new LinkedList<T>();
        LinkedList ll = table[a];
        if(!ll.contains(item)){
            ll.add(item);
            n++;
        }
    }

    @Override
    public void remove(T item) {
        int a = hash(item);
        if(table[a] == null)
            return;
        LinkedList ll = table[a];
        if(ll.remove(item))
            n--;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean contains(T item) {
        int a = hash(item);
        if (table[a] == null)
            return false;
        LinkedList ll = table[a];
        if (ll.contains(item))
            return true;
        else
            return false;
    }

    @Override
    public String toString(){
        String r = "";
        for(int i = 0; i< table.length; i++) {
            if (table[i] != null) {
                for (T t : table[i]) {
                    if (r != "")
                        r += ", ";
                    r += t;
                }
            }
        }
        return r;
    }


}
