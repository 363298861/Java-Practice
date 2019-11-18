package Abstract_type.Tree;

public class Tree {
    Node root;

    public class Node {
        public Integer value;
        public Node left, right, parent;

        public Node(Integer value){
            this.value = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    public Tree(){
        root = null;
    }

    public void insert(Integer value, Node n){
        if(n.value > value){
            if(n.left.value == null) {
                n.left = new Node(value);
                n.left.parent = n;
            }
            else
                insert(value, n.right);
        }else{

        }
    }

    public void insert1(Integer value){
        Node parent = null;
        Node x = root;
        while(x != null){
            parent = x;
            if(x.value > value){
                x = x.left;
            }else
                x = x.right;
        }
        if(value > parent.value){
            x = new Node(value);
            parent.right = x;
            x.parent = parent;
        }
    }

    public void insert(Integer value){
        insert(value, root);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(10);
        tree.insert(3);
        System.out.println(tree);
        Tree tree2 = new Tree();
        tree2.insert1(2);
        System.out.println(tree2);

    }
}
