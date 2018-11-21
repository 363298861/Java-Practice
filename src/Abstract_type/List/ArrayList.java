package Abstract_type.List;

public class ArrayList<T> implements List<T> {

    private int INITIAL_SIZE = 2;
    private static final double GROWTH_FACTOR = 1.5;

    private T[] list = (T[]) new Object[INITIAL_SIZE];
    private int elements = 0;


    @Override
    public void add(T value) {
        if(elements == list.length){
            T[] tem = (T[]) new Object[(int) (list.length * GROWTH_FACTOR)];
            for(int i = 0; i < elements; i++)
                tem[i] = list[i];
            list = tem;
        }
        list[elements] = value;
        elements++;

    }

    @Override
    public void remove(int index) {
        elements--;
        for (int i = index; i < elements; i++)
            list[i] = list[i + 1];

    }

    @Override
    public T get(int index) {
        return list[index];
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public void reverse() {
        T[] tem = (T[]) new Object[elements];
        for(int i = 0; i < elements; i++)
            tem[i] = list[elements - i - 1];
        list = tem;
    }

    @Override
    public String toString(){
        String retur = "";
        for(int i = 0; i < elements; i++){
            if(i != 0)
                retur += " ";
            retur += list[i];
        }
        return retur;
    }
}
