package Abstract_type.RedBlackTree;

import java.util.TreeMap;

public class RBtreeDemo {
    public static void main(String[] args) {
        System.out.println("Construct a red-black tree.");
        RBTree<Integer> tree = new RBTree<Integer>();
        for(int i=0; i<20; ++i) {
            tree.insert(i);
        }

        System.out.println("Pre-order traversal result of the tree:");
        tree.preOrder();
        tree.remove(13);
        tree.preOrder();

    }
}
