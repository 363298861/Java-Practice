package Abstract_type.Map;

public class BSTMap<K, V> implements Map<K, V> {

    BStree tree;
    int n;
    class KVpair {
        K key;
        V value;

        KVpair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "(" + key + ", " + value +")";
        }
    }


    class BStree{
        KVpair node;
        BStree left, right;

        BStree add(KVpair kv){
            if (node == null) {
                node = kv;
                return this;
            }else if(node.equals(kv))
                return null;
            else if (kv.key.hashCode() < node.key.hashCode()) {
                if(left == null)
                    left = new BStree();
                return left.add(kv);
            }else{
                if (right == null) {
                    right = new BStree();
                }
                return right.add(kv);
            }
        }

        void add(BStree subtree){
            if (subtree != null) {
                add(subtree.node);
                add(subtree.left);
                add(subtree.right);
            }
        }

        BStree find(K key, boolean delete){
            if(node == null)
                return null;
            else if(node.key.equals(key))
                return this;
            else if(key.hashCode() < node.key.hashCode())
                return se(key, left, delete);
            else
                return se(key, right, delete);
        }


        BStree se(K key, BStree subtree, boolean delete){
            if(subtree == null)
                return null;
            else{
                BStree t = subtree.find(key, delete);
                if(t == subtree && delete){
                    if(subtree == left)
                        left = null;
                    else
                        right = null;
                }
                return t;
            }
        }




        @Override
        public String toString(){
            String r = "";
            if(node != null){
                if(left != null)
                    r += left + ", ";
                r += node;
                if(right != null)
                    r += ", " + right;
            }
            return r;
        }
    }



    @Override
    public void put(K key, V value) {
        if(tree == null)
            tree = new BStree();
        if (tree.find(key, false) == null) {
            tree.add(new KVpair(key, value));
            n++;
        }else
            tree.find(key, false).node.value = value;
    }

    @Override
    public void remove(K key) {
        BStree root = tree.find(key, true);
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
    public V get(K key) {
        if(tree.find(key, false) != null)
            return tree.find(key, false).node.value;
        else
            return null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public String toString(){
        String r = "";
        r += tree;
        return r;
    }
}