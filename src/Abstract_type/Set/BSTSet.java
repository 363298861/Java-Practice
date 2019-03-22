package Abstract_type.Set;

public class BSTSet<T> implements Set<T> {

    BStree tree;
    int n;

    class BStree{
        T node;
        BStree left, right;

        BStree add(T element){
            if(node == null){
                node = element;
                return this;
            }else if(node.equals(element))
                return null;
            else if(element.hashCode() < node.hashCode()){
                if(left == null)
                    left = new BStree();
                return left.add(element);
            }else{
                if(right == null)
                    right = new BStree();
                return right.add(element);
            }
        }

        void add(BStree subtree){
            if (subtree != null) {
                add(subtree.node);
                add(subtree.left);
                add(subtree.right);
            }
        }

        BStree find(T element, boolean delete){
            if (node == null) {
                return null;
            }else if(node.equals(element)){
                return this;
            } else if (element.hashCode() < node.hashCode()) {
                return search(element, left, delete);
            }else
                return search(element, right, delete);
        }

        BStree search(T element, BStree subtree, boolean delete){
            if (subtree == null) {
                return null;
            }else {
                BStree t = subtree.find(element, delete);
                if (t == subtree && delete) {
                    if (subtree == left) {
                        left = null;
                    }else
                        right = null;
                }
                return t;
            }
        }

        @Override
        public String toString(){
            String r = "";
            if (node != null) {
                if (left != null) {
                    r += left + ", ";
                }
                r += node;
                if (right != null){
                    r += ", " + right;
                }
            }
            return r;
        }
    }



    @Override
    public void add(T element) {
        if(tree == null)
            tree = new BStree();
        if (tree.find(element, false) == null) {
            tree.add(element);
            n++;
        }else
            tree.find(element, false).node = element;

    }

    @Override
    public void remove(T element) {
        BStree root = tree.find(element, true);
        if (root != null) {
            root.node = null;
            BStree l = root.left;
            BStree r = root.right;
            root.left = null;
            root.right = null;
            tree.add(l);
            tree.add(r);
            n--;
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean contains(T element) {
        return tree.find(element, false) != null ;
    }

    @Override
    public String toString(){
        String r ="";
        r += tree;
        return r;
    }

}
