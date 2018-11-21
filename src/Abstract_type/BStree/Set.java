package Abstract_type.BStree;

public interface Set<T> {
    void add(T element);
    void remove(T element);
    int size();
    boolean contains(T element);
    String toString();
}
