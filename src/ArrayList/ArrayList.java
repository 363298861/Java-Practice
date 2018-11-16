package ArrayList;

import java.util.LinkedList;

public class ArrayList<T> implements List<T> {
    static final int Size = 2;
    static final double Growth = 1.5;
    T[] list = (T[]) new Object[Size];
    int n;


    @Override
    public void add(T value) {
        if(n == list.length){
            T[] tem = (T[]) new Object[(int) (n * Growth)];
            for(int i = 0; i < n; i++)
                tem[i] = list[i];
            list = tem;
        }
        list[n++] = value;
    }

    @Override
    public void remove(int index) {
        for(int i = index; i < list.length - 1; i++)
            list[i] = list[i + 1];
        n--;
    }

    @Override
    public T get(int index) {
        return list[index];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void reverse() {
        T[] tem = (T[]) new Object[list.length];
        for(int i = 0; i < n; i++)
            tem[i] = list[n - i - 1];
        list = tem;
    }

    @Override
    public String toString() {
        String r = "";
        for (int i = 0; i < n; i++) {
            if (r != "") {
                r += " ";
            }
            r += list[i].toString();
        }
        return r;
    }
}
