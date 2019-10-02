package Abstract_type.RedBlackTree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import java.util.TreeMap;



public class hashTable<K extends Comparable<K>, V> {

    public Node<K, V> root; // The root node of the tree



    public class Node<K extends Comparable<K>, V> {

        Colour colour;       // Node colour

        K key;

        V value;// Node key

        Node<K, V> parent;      // Parent node

        Node<K, V> l, r;        // Children nodes



        // Value node

        public Node(K key, V value) {

            this.key = key;

            this.value = value;

            this.colour = Colour.RED;

            this.parent = null;



            // Initialise children leaf nodes

            this.l = new Node<>();

            this.r = new Node<>();

            this.l.parent = this;

            this.r.parent = this;

        }



        // Leaf node

        public Node() {

            this.key = null;

            this.colour = Colour.BLACK;

        }



        // Insert node into tree, ignoring colour

        public void insert(Node<K, V> n) {

            if (this.key == null)

            {

                if (parent == null)

                    this.key = n.key;

                else {

                    int i = n.key.compareTo(parent.key);

                    if (i < 0) parent.l = n;

                    else if (i > 0) parent.r = n;

                    n.parent = parent;

                }

            }

            else {

                int i = n.key.compareTo(key);

                if(i < 0){

                    l.insert(n);

                }else if (i > 0){

                    r.insert(n);

                }

            }

        }



        // Rotate the node so it becomes the child of its right branch

        /*

            e.g.

                  [x]                    b

                 /   \                 /   \

               a       b     == >   [x]     f

              / \     / \           /  \

             c  d    e   f         a    e

                                  / \

                                 c   d

        */

        public void rotateLeft() {

            // Make parent (if it exists) and right branch point to each other

            if (parent != null) {

                // Determine whether this node is the left or right child of its parent

                if (parent.l.key == key) {

                    parent.l = r;

                } else {

                    parent.r = r;

                }

            }

            boolean a = parent == null;

            r.parent = parent;



            parent = r;

            // Take right node's left branch

            r = parent.l;

            r.parent = this;

            // Take the place of the right node's left branch

            parent.l = this;

        }



        // Rotate the node so it becomes the child of its left branch

        /*

            e.g.

                  [x]                    a

                 /   \                 /   \

               a       b     == >     c     [x]

              / \     / \                   /  \

             c  d    e   f                 d    b

                                               / \

                                              e   f

        */

        public void rotateRight() {

            if (parent != null) {

                if (parent.l.key == key) {

                    parent.l = l;

                } else {

                    parent.r = l;

                }

            }

            l.parent = parent;



            parent = l;

            // Take right node's left branch

            l = parent.r;

            l.parent = this;

            // Take the place of the right node's left branch

            parent.r = this;

            // TODO: Implement this function (2/3)

            // HINT: It is the mirrored version of rotateLeft()

        }
        @Override
        public String toString(){
            if(l != null && r != null)
                return l.toString() + "(" + key.toString()+ ", " + value.toString() + ")" + r.toString();
            return "zhiyuan";
        }


    }



    // Initialise empty hashTable

    public hashTable() {

        root = null;

    }

    private void Left_Rotate(hashTable<K, V> t, Node<K, V> x){

        Node<K, V> y = x.r;

        x.r = y.l;

        if (y.l.key != null) y.l.parent = x;

        y.parent = x.parent;

        if (x.parent == null)t.root = y;

        else if (x == x.parent.l)x.parent.l = y;

        else x.parent.r = y;

        y.l = x;

        x.parent = y;

    }



    private void Right_Rotate(hashTable<K, V> t, Node<K, V> x){

        Node<K, V> y = x.l;

        x.l = y.r;

        if (y.r.key != null) y.r.parent = x;

        y.parent = x.parent;

        if (x.parent == null)t.root = y;

        else if (x == x.parent.r)x.parent.r = y;

        else x.parent.l = y;

        y.r = x;

        x.parent = y;

    }







    // Insert node into hashTable

    private void insert(Node<K, V> x) {

        // TODO: Complete this function (3/3)

        // You need only finish cases 1, 2 and 3; the rest has been done for you



        // Insert node into tree



        if (root == null) root = x;

        else root.insert(x);



        // Fix tree

        while (x.key != root.key && x.parent.colour == Colour.RED) {

            boolean left = x.parent == x.parent.parent.l; // Is parent a left node

            Node<K, V> y = left ? x.parent.parent.r : x.parent.parent.l; // Get opposite "uncle" node to parent



            if (y.colour == Colour.RED) {

                // Case 1: Recolour

                // TODO: Implement this

                x.parent.parent.colour = Colour.RED;

                x.parent.colour = Colour.BLACK;

                y.colour = Colour.BLACK;

                // Check if violated further up the tree

                x = x.parent.parent;

            } else {

                if (x.key == (left ? x.parent.r.key : x.parent.l.key)) {

                    // Case 2 : Left (uncle is left node) / Right (uncle is right node) Rotation

                    x = x.parent;

                    if (left) {

                        // Perform left rotation

                        if (x.key == root.key) root = x.r; // Update root

                        x = x.parent;

                        x.rotateLeft();

                    } else {

                        // This is part of the "then" clause where left and right are swapped

                        // Perform right rotation

                        // TODO: Implement this

                        if (x.key == root.key) root = x.l;

                        x = x.parent;

                        x.rotateRight();

                    }



                }

                // Adjust colours to ensure correctness after rotation

                x.parent.colour = Colour.BLACK;

                x.parent.parent.colour = Colour.RED;

                // Case 3 : Right (uncle is left node) / Left (uncle is right node) Rotation

                // TODO: Complete this

                if (left) {

                    // Perform right rotation

                    boolean a = x.parent.parent == root;

                    if (a) root = x.parent;

                    x.parent.parent.rotateRight();





                    //  x = x.l;

                } else

                {

                    // This is part of the "then" clause

                    // where left and right are swapped

                    // Perform left rotation

                    boolean a = x.parent.parent == root;

                    if (a) root = x.parent;

                    x.parent.parent.rotateLeft();



                    //  x = x.l;

                }

            }

        }



        // Ensure property 2 (root and leaves are black) holds

        root.colour = Colour.BLACK;

    }





    // Demo functions

    // (Safely) insert a key into the tree

    public void insert(K key, V value) {

        Node<K, V> node = new Node<K, V>(key, value);

        Node<K, V> n = search(key);

        if (n == null) insert(node);

        else n.value = value;

    }



    private Node<K, V> tree_Min(Node<K, V> x)

    {

        while (x.l.key != null){

            x = x.l;

        }

        return x;

    }



    // Return the result of a pre-order transversal of the tree

    private void preOrder(Node<K, V> tree) {

        if(tree != null && tree.key != null) {

            System.out.print("("+tree.key+" "+ tree.value+")" +" ");

            preOrder(tree.l);

            preOrder(tree.r);

        }

    }

    @Override
    public String toString(){
        String res = "";
        if(root != null && root.key != null) {

            res += "("+root.key+" "+ root.value+")" +" ";

            res += root.l.toString();

            res += root.r.toString();

        }
        return res;
    }





    public void preOrder() {

        preOrder(root);

        System.out.println();

    }



    // Return the corresponding node of a key, if it exists in the tree

    private Node<K, V> find(Node<K, V> x, K v) {

        if (x == null )return null;

        if (x.key == null)

            return null;



        int cmp = v.compareTo(x.key);

        if (cmp < 0)

            return find(x.l, v);

        else if (cmp > 0)

            return find(x.r, v);

        else

            return x;

    }



    public Node<K, V> search(K key) {

        return find(root, key);

    }



    public void delet(K value){

        Node<K, V> z, node;



        if ((z = find(root, value)) != null)

            if ( (node = delet(this, z)) != null)

                node = null;

    }



    private Node<K, V> delet(hashTable<K, V> T, Node<K, V> n)

    {

        Node<K, V> y = n;

        Node<K, V> x = null;

        Colour yc = y.colour;

        if (n.l.key == null){

            x = n.r;

            transprant(this, n, n.r);

        }else if (n.r.key == null){

            x = n.l;

            transprant(this, n, n.l);

        }else {

            y = tree_Min(n.r);

            yc = y.colour;

            x = y.r;

            if (y.parent == n)x.parent = y;

            else {

                transprant(this, y, y.r);

                y.r = n.r;

                y.r.parent = y;

            }

            transprant(this, n, y);

            y.l = n.l;

            y.l.parent = y;

            y.colour = n.colour;

        }

        if (yc == Colour.BLACK)

            fixUp(this, x);



        return n;

    }





    private void transprant(hashTable<K, V> t, Node<K, V> u, Node<K, V> v){

        if (u == root) root = v;

        else if (u == u.parent.l)u.parent.l = v;

        else u.parent.r = v;

        v.parent = u.parent;

        Map a = new TreeMap();

    }





    private void fixUp(hashTable<K, V> t, Node<K, V> x){

        while (x != root && x.colour == Colour.BLACK){

            Node<K, V> w;

            if (x == x.parent.l){

                w = x.parent.r;

                if (w.colour == Colour.RED){

                    w.colour = Colour.BLACK;

                    x.parent.colour = Colour.RED;

                    Left_Rotate(this, x.parent);

                    w = x.parent.r;

                }



                if (w.l.colour == Colour.BLACK && w.r.colour == Colour.BLACK){

                    w.colour = Colour.RED;

                    x = x.parent;

                }else {

                    if (w.r.colour == Colour.BLACK){

                        w.l.colour = Colour.BLACK;

                        w.colour = Colour.RED;

                        Right_Rotate(this, w);

                        w = x.parent.r;

                    }

                    w.colour = x.parent.colour;

                    x.parent.colour = Colour.BLACK;

                    w.r.colour = Colour.BLACK;

                    Left_Rotate(this, x.parent);

                    x = root;

                }

            }else {

                w = x.parent.l;

                if (w.colour == Colour.RED){

                    w.parent.colour = Colour.RED;

                    w.colour = Colour.BLACK;

                    Right_Rotate(this, x.parent);

                    w = x.parent.l;

                }

                if (w.l.colour == Colour.BLACK && w.r.colour == Colour.BLACK){

                    w.colour = Colour.RED;

                    x = x.parent;

                }else {

                    if (w.l.colour == Colour.BLACK){

                        w.r.colour = Colour.BLACK;

                        w.colour = Colour.BLACK;

                        Left_Rotate(this, w);

                        w = x.parent.l;

                    }

                    w.colour = x.parent.colour;

                    x.parent.colour = Colour.BLACK;

                    w.l.colour = Colour.BLACK;

                    Right_Rotate(this, x.parent);

                    x = root;

                }



            }

            x.colour = Colour.BLACK;

        }

    }



    public enum Colour {

        RED,

        BLACK

    }

    public void save(String file){
        try{
            BufferedWriter b = new BufferedWriter(new FileWriter(file));
            String line = root.toString();
            b.write(line);
            b.newLine();
            b.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        hashTable h = new hashTable();
        h.insert(1, 'a');
        h.insert(2, 'b');
        h.insert(3, 'd');
        h.insert(4, 'e');
        h.insert(5, 'a');
        h.insert(6, 'b');
        h.insert(7, 'd');
        h.insert(8, 'e');
        h.save("1.txt");

    }







}


/*public class RBTree<T extends Comparable> {
    public class Node<T extends Comparable> {
        public Node(T value){ }

        public Node(){ }

        public void insert(Node<T> n){ }

// Rotate the node so it becomes the child of its right branch
        /*
            e.g.
                  [x]                    b
                 /   \                 /   \
               a       b     == >   [x]     f
              / \     / \           /  \
             c  d    e   f         a    e
                                  / \
                                 c   d

        public void rotateLeft(){ }

// Rotate the node so it becomes the child of its left branch

            e.g.
                  [x]                    a
                 /   \                 /   \
               a       b     == >     c     [x]
              / \     / \                   /  \
             c  d    e   f                 d    b
                                               / \
                                              e   f

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

