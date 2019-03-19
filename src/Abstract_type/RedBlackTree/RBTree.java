package Abstract_type.RedBlackTree;

public class RBTree<T extends Comparable> {
    private Node<T> root;

    public class Node<T extends Comparable> {
        Color color;
        T value;
        Node<T> parent, l, r;

        public Node(T value){
            this.value = value;
            this.color = Color.Red;
            this.parent = null;
            this.l = new Node<>();
            this.r = new Node<>();
            this.l.parent = this;
            this.r.parent = this;
        }

        public Node(){
            this.value = null;
            this.color = Color.Black;
        }

        public void insert(Node<T> n){
            if(n.value == null)
                return;
            if(this.value == null){
                this.value = n.value;
                this.l = new Node<>();
                this.r = new Node<>();
                this.l.parent = this;
                this.r.parent = this;
                this.insert(n.l);
                this.insert(n.r);
            }else{
                if(this.value.compareTo(n.value) < 0)
                    this.r.insert(n);
                else if(this.value.compareTo(n.value) > 0)
                    this.l.insert(n);
                else{
                    this.insert(n.l);
                    this.insert(n.r);
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
        public void rotateLeft(){
            if(this.parent != null) {
                if (this.value.equals(this.parent.l.value))
                    parent.l = r;
                else
                    parent.r = r;
            }

            r.parent = parent;
            parent = r;
            r = parent.l; //confused
            r.parent = this;
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

        public void rotateRight(){
            if(parent != null){
                if(parent.l.value.equals(value))
                    parent.l = l;
                else
                    parent.r = l;
            }
            l.parent = parent;
            parent = l;
            l = parent.r;
            parent.r = this;
            l.parent = this;
        }
    }



    public RBTree(){
        root = null;
    }

    private void insert(Node<T> x){
        if(root == null)
            root = x;
        else
            root.insert(x);

        while(!x.value.equals(root.value) && x.parent.color == Color.Red){
            boolean left = x.parent == x.parent.parent.l;
            Node<T> y = left ? x.parent.parent.r : x.parent.parent.l;

            if(y.color == Color.Red){
                x.parent.color = Color.Black;
                y.color = Color.Black;
                x.parent.parent.color = Color.Red;
                x = x.parent.parent;
            }
            else{
                if(x.value == (left ? x.parent.r.value : x.parent.l.value)){
                    x = x.parent;
                    if(left){
                        if(x.value == root.value)
                            root = x.r;
                        x.rotateLeft();
                    }else{
                        if(x.value == root.value)
                            root = x.l;
                        x.rotateRight();
                    }
                }
                x.parent.color = Color.Black;
                x.parent.parent.color = Color.Red;

                if(left){
                    if(x.value.equals(root.value))
                        root = x.l;
                    x.rotateRight();
                }else{
                    if(x.value.equals(root.value))
                        root = x.r;
                    x.rotateLeft();
                }
            }
        }
        root.color = Color.Black;
    }

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
