package Abstract_type.BinaryTree;

public class NonEmptyBinaryTree<T extends Comparable> extends BinaryTree<T> {

    private T value;
    private BinaryTree l, r;

    public NonEmptyBinaryTree(T value){
        this.value = value;
        this.l = new EmptyBinaryTree();
        this.r = new EmptyBinaryTree();
    }

    public NonEmptyBinaryTree(T value, BinaryTree l, BinaryTree r){
        this.value = value;
        this.l = l;
        this.r = r;
    }

    @Override
    public NonEmptyBinaryTree insert(T d) {
        if(this.value.equals(d)){
            return this;
        }else if(this.value.compareTo(d) < 0) {
            return new NonEmptyBinaryTree(value, l, r.insert(d));
        }
        else {
            return new NonEmptyBinaryTree(value, l.insert(d), r);
        }
    }

    @Override
    public int size() {
        return 1 + l.size() + r.size();
    }

    @Override
    public int height() {
        return 1 + Math.max(this.r.height(), this.l.height());
    }

    @Override
    public String show() {
        return null;
    }

    @Override
    public String treeshow() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public BinaryTree remove(T d) {
        if(value.equals(d)){
            if(l.isEmpty())
                return r;
            else if (r.isEmpty())
                return l;
            else{
                T value = (T) l.biggest();
                return new NonEmptyBinaryTree(value, l.remove(d), r);
            }
        }
        else if (value.compareTo(d) < 0)
            return new NonEmptyBinaryTree(value, l, r.remove(d));
        else
            return new NonEmptyBinaryTree(value, l.remove(d), r);
    }

    @Override
    public T biggest() {
        if(r.isEmpty())
            return value;
        else
            return (T) this.r.biggest();
    }

    @Override
    public boolean elementOf(T d) {
        if(this.value.equals(d))
            return true;
        else if(this.value.compareTo(d) < 0 && !(this.r instanceof EmptyBinaryTree))
            return this.r.elementOf(d);
        else if(this.value.compareTo(d) >= 0 && !(this.l instanceof EmptyBinaryTree))
            return this.l.elementOf(d);
        else
            return false;
    }

    @Override
    public int balanceFactor() {
        return 0;
    }

    @Override
    public boolean avlBalanced() {
        return false;
    }

    @Override
    public String toString(){
        String res = "";
        if(!l.isEmpty()){
            res += l + ", ";
        }
        res += value.toString() + ", ";
        if(!r.isEmpty())
            res += r + ", ";

        return res;
    }

    public static void main(String[] args) {
        NonEmptyBinaryTree t = new NonEmptyBinaryTree(10);
        System.out.println(t);
        t = t.insert(12);
        System.out.println(t);
        t = t.insert(8);
        System.out.println(t);
        t = t.insert(123);
        System.out.println(t);
        t = t.insert(11);
        System.out.println(t);
        System.out.println(t.size());
    }
}
