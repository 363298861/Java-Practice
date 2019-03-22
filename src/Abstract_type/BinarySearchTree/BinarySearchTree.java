package Abstract_type.BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> _root; //Root node

    public class Node<T extends Comparable<T>> {
        T _value;           // Node value
        Node<T> _left;      // Left child
        Node<T> _right;     // Right child
        Node<T> _parent;    // Parent node

        public Node(T key, Node<T> parent, Node<T> left, Node<T> right) {
            _value = key;
            _left = left;
            _right = right;
            _parent = parent;
        }

        public T getKey() {
            return _value;
        }

        public String toString() {
            return _value.toString();
        }
    }

    public BinarySearchTree() {
        _root=null;
    }

    private static int max(int a, int b) {
        return a>b ? a : b;
    }

    private int height(Node<T> tree) {
        if (tree != null)
            return 1 + max(height(tree._left), height(tree._right));

        return 0;
    }

    public int height() {
        return height(_root);
    }

    // Pre-Order Traversal
    private String nlr(Node<T> tree) {
        if(tree != null) {
            String result = tree._value.toString();
            String leftResult = nlr(tree._left);
            String rightResult = nlr(tree._right);
            if(!leftResult.equals("")) {
                result += " " + leftResult;
            }
            if(!rightResult.equals("")) {
                result += " " + rightResult;
            }
            return result;
        }
        return "";
    }

    public String nlr() {
        return nlr(_root);
    }

    // Find item in the tree
    private Node<T> find(Node<T> x, T key) {
        if (x==null)
            return x;

        int compare = key.compareTo(x._value);
        if (compare < 0)
            return find(x._left, key);
        else if (compare > 0)
            return find(x._right, key);
        else
            return x;
    }

    public Node<T> find(T key) {
        return find(_root, key);
    }

    // Insert the value to the BST.
    private void insert(BinarySearchTree<T> bst, Node<T> z) {
        //!TODO: Add your implementation here.
        if(z._value == null)
            return;
        if(bst._root == null)
            bst._root = z;
        else if(z._value.compareTo(bst._root._value) < 0){
            BinarySearchTree<T> nbst = new BinarySearchTree<>();
            nbst._root = bst._root._left;
            insert(nbst, z);
            bst._root._left = nbst._root;
        }else if(z._value.compareTo(bst._root._value) > 0){
            BinarySearchTree<T> nbst = new BinarySearchTree<>();
            nbst._root = bst._root._right;
            insert(nbst, z);
            bst._root._right = nbst._root;
        }else{
            insert(bst, z._left);
            insert(bst, z._right);
        }
    }

    public void insert(T key) {
        insert(this, new Node<T>(key,null,null,null));
    }

    // Remove a node from the BST
    private Node<T> remove(BinarySearchTree<T> bst, Node<T> z) {
        //!TODO: Add your implementation here.
        Node<T> re;
        if((re = bst.find(z._value)) != null){
            re._value = null;
            Node l = re._left;
            Node r = re._right;
            re._right = null;
            re._left = null;
            re._parent = null;
            insert(bst, l);
            insert(bst, r);
        }
        return bst._root;
    }

    public void remove(T key) {
        Node<T> z, node;

        if ((z = find(_root, key)) != null)
            if ( (node = remove(this, z)) != null)
                node = null;
    }

}

