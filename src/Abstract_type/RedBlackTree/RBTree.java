package Abstract_type.RedBlackTree;

public class RBTree<T extends Comparable> {


    public class Node<T extends Comparable> {
        public Node(T value){ }

        public Node(){ }

        public void insert(Node<T> n){ }

        public void rotateLeft(){ }

        public void rotateRight(){ }
    }

    

    public RBTree(){ }

    private void insert(Node<T> x){ }

    public void insert(T value){ }

    private void preOrder(){ }

    private Node<T> find(Node<T> x, T v){ return null; }

    public Node<T> search(T key){ return null; }

    public enum Color {
        Red,
        Black;
    }
}


/*public class RBTree<T extends Comparable> {
    public class Node<T extends Comparable> {
        public Node(T value){ }

        public Node(){ }

        public void insert(Node<T> n){ }

        public void rotateLeft(){ }

        public void rotateRight(){ }
    }

    public RBTree(){ }

    private void insert(Node<T> x){ }

    public void insert(T value){ }

    private void preOrder(){ }

    private Node<T> find(Node<T> x, T v){ return null; }

    public Node<T> search(T key){ return null; }

    public enum Color {
        Red,
        Black;
    }
}*/
