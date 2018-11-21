package Abstract_type.HashSet;

public interface Set<T> {
    void add(T element);
    void remove(T element);
    boolean contains(T element);
    int size();
    String toString();
}
