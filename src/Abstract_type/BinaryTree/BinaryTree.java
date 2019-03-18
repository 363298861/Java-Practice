package Abstract_type.BinaryTree;

public abstract class BinaryTree<T> {

    public abstract BinaryTree insert(T d); // add an element to the tree, this returns the new/modified tree

    public abstract int size(); // the number of element in the tree

    public abstract int height(); // the height of the tree

    public abstract String show(); // show the tree

    public abstract String treeshow(); // print the tree using an ascii drawing

    public abstract boolean isEmpty(); // check if the tree is empty

    public abstract BinaryTree remove(T d); // remove an element from the tree, this return the new/modifited tree

    public abstract T biggest(); // find the biggest element in the tree

    public abstract boolean elementOf(T d); // check if the element is in the set

    public abstract int balanceFactor();
    public abstract boolean avlBalanced();
}

