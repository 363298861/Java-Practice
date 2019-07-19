package Abstract_type.BinaryTree;

public class EmptyBinaryTree<T extends Comparable> extends BinaryTree<T> {

    @Override
    public BinaryTree insert(T d) {
        return new NonEmptyBinaryTree(d);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public String show() {
        return null;
    }

    @Override
    public String treeshow() {
        return "";
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public BinaryTree remove(T d) {
        return null;
    }

    @Override
    public T biggest() {
        return null;
    }

    @Override
    public boolean elementOf(T d) {
        return false;
    }

    @Override
    public int balanceFactor() {
        return 0;
    }

    @Override
    public boolean avlBalanced() {
        return false;
    }

    @Override
    public String toString(){
        return "";
    }
}
