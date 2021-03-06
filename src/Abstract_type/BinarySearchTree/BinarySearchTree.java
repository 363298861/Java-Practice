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

        @Override
        public String toString(){
            String res = "";
            if(_left != null)
                res += _left.toString();
            if(_value != null) {
                res += _value.toString() + ", ";
            }
            if(_right != null)
                res += _right.toString();
            return res;
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
        Node<T> y = null;
        Node<T> x = bst._root;
        while(x != null){
            y = x;
            if(x._value.compareTo(z._value) > 0)
                x = x._left;
            else
                x = x._right;
        }
        z._parent = y;
        if(y == null){
            bst._root = z;
        }else if(y._value.compareTo(z._value) > 0)
            y._left = z;
        else
            y._right = z;
    }

    public void insert(T key) {
        insert(this, new Node<T>(key,null,null,null));
    }

    private Node<T> successor(Node<T> x){
        Node<T> y = x._parent;
        if(x._right != null)
            return minimum(x._right);
        while (y != null && x == y._right){
            x = y;
            y = y._parent;
        }
        return y;
    }

    private Node<T> minimum(Node<T> x){
        if(x == null || x._left == null)
            return x;
        else
            return minimum(x._left);
    }

    // Remove a node from the BST
    private Node<T> remove(BinarySearchTree<T> bst, Node<T> z) {
        //!TODO: Add your implementation here.
        if(bst.find(z._value) == null)
            return null;
        Node<T> x, y;
        if(z._left == null || z._right == null)
            y = z;
        else
            y = successor(z);
        if(y._left != null)
            x = y._left;
        else
            x = y._right;
        if(x != null)
            x._parent = y._parent;
        if(y._parent == null)
            bst._root = x;
        else if(y == y._parent._left)
            y._parent._left = x;
        else
            y._parent._right = x;

        if(y != z)
            z._value = y._value;
        return y;
    }

    public void remove(T key) {
        Node<T> z, node;

        if ((z = find(_root, key)) != null)
            if ( (node = remove(this, z)) != null)
                node = null;
    }

    @Override
    public String toString(){
        return _root.toString();
    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(6);
        b.insert(2);
        b.insert(9);
        b.insert(15);
        System.out.println(b.nlr());
    }
}

