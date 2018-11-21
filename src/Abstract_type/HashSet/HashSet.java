package Abstract_type.HashSet;

import java.util.LinkedList;

public class HashSet<T> implements Set<T> {

    final static int SIZE = 20;
    LinkedList<T>[] table;
    int elements;

    public HashSet(){
        table = new LinkedList[SIZE];
    }
    private int hash(T element){
        return Math.abs(element.hashCode() % 20);
    }

    @Override
    public void add(T element) {
        int a = hash(element);
        if(table[a] == null)
            table[a] = new LinkedList<>();
        if(!table[a].contains(element)) {
            table[a].add(element);
            elements++;
        }
    }

    @Override
    public void remove(T element) {
        int a = hash(element);
        if(table[a] != null){
            if(table[a].remove(element))
                elements--;
        }
    }

    @Override
    public boolean contains(T element) {
        int a = hash(element);
        if(table[a] != null){
            if(table[a].contains(element))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString(){
        String rtn = "";
        for(int i = 0; i < table.length; i++){
            LinkedList<T> a = table[i];
            if(a != null){
                for(T b : a){
                    if(!rtn.equals(""))
                        rtn += ", ";
                    rtn += b.toString();
                }
            }
        }
        return rtn;
    }
}
