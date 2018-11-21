package Abstract_type.BSTMap;

public class BSTMap<K, V> implements Map<K, V> {

    BStree tree;
    int elements;

    class KVpair {
        K key;
        V value;

        KVpair(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "(" + key + ", " + value + ")";
        }
    }


    class BStree<T> {
        KVpair kv;
        BStree left, right;

        BStree add(KVpair kv){
            if(this.kv == null) {
                this.kv = kv;
                return this;
            } else if (this.kv.equals(kv)) {
                return null;
            }else if (kv.key.hashCode() < this.kv.key.hashCode()){
                if(left == null)
                    left = new BStree();
                return left.add(kv);
            }else {
                if(right == null)
                    right = new BStree();
                return right.add(kv);
            }
        }

        void add(BStree subtree){
            if(subtree != null && subtree.kv != null){
                add(subtree.kv);
                add(subtree.left);
                add(subtree.right);
            }
        }

        BStree find(K key, boolean delete){
            if(key == null || this.kv == null){
                return null;
            }else if (this.kv.key.equals(key))
                return this;
            else if(key.hashCode() < kv.key.hashCode()){
                return searchSubTree(key, left, delete);
            }else {
                return searchSubTree(key, right, delete);
            }
        }

        BStree searchSubTree(K key, BStree subtree, boolean delete){
            if(subtree == null)
                return null;
            else {
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
            String rtn = "";
            if(kv != null){
                if(left != null)
                    rtn += left + ", ";
                rtn += kv;
                if(right != null)
                    rtn += ", " + right;
            }
            return rtn;
        }


    }

    @Override
    public void put(K key, V value) {
        if(tree == null){
            tree = new BStree();
        }
        BStree t = tree.find(key, false);
        if(t == null) {
            tree.add(new KVpair(key, value));
            elements++;
        }
        else{
            t.kv.value = value;
        }
    }

    @Override
    public void remove(K key) {
        BStree root = tree.find(key, true);
        if(root != null){
            root.kv = null;
            BStree l = root.left;
            BStree r = root.right;
            root.left = null;
            root.right = null;
            tree.add(l);
            tree.add(r);
            elements--;
        }
    }

    @Override
    public V get(K key) {
        if(tree == null)
            return null;
        else{
            BStree t = tree.find(key, false);
            if(t == null)
                return null;
            else
                return (V) t.kv.value;
        }

    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public String toString(){
        String rtn = "";
        if (tree != null){
            rtn += tree;
        }
        return rtn;
    }
}
