package HashSet;

public interface Set<T> {
    void add(T item);
    void remove(T item);
    int size();
    boolean contains(T item);
    String toString();
}
