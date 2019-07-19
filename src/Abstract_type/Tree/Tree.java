package Abstract_type.Tree;

public class Tree<T extends Comparable<T>>{
    T value;
    Tree left, right;

    Tree(T value, Tree left, Tree right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /*public void insert(T n){
        if(n.compareTo(value) < 0){
            if(left == null) {
                left = new Tree(n, null, null);
            }
            else
                left.insert(n);
        }
        else if(n.compareTo(value) > 0){
            if(right == null)
                right = new Tree(n, null, null);
            else
                right.insert(n);
        }
    }*/

    public Tree insert(T n){
        if(value == n)
            return this;
        else if(value.compareTo(n) < 0){
            if(right == null)
                return new Tree(value, left, new Tree(n, null, null));
            return new Tree(value, left, right.insert(n));
        }else{
            if(left == null)
                return new Tree(value, new Tree(n, null, null), right);
            return new Tree(value, left.insert(n), right);
        }
    }

    private int height(){
        if(left == null && right == null)
            return 1;
        else if(left == null)
            return 1 + right.height();
        else if(right == null)
            return 1 + left.height();
        return 1 + Math.max(left.height(), right.height());
    }

    public Tree remove(T n){
        if(n == value){
            if(left == null)
                return right;
            else if(right == null)
                return left;
            else{
                T d = (T) left.biggest();
                return new Tree(d, left.remove(d), right);
            }
        }else if(n.compareTo(value) < 0)
            return new Tree(value, left.remove(n), right);
        else
            return new Tree(value, left, right.remove(n));
    }

    private T biggest(){
        if(right == null)
            return value;
        else
            return (T) right.biggest();
    }

    public boolean find(T n){
        if(n.equals(value))
            return true;
        else if(n.compareTo(value) < 0){
            if(left == null)
                return false;
            return left.find(n);
        }else{
            if(right == null)
                return false;
            return right.find(n);
        }

    }

    public String preoderTraversal(){
        String res = "";
        res += value + " ";
        if(left != null)
            res += left.preoderTraversal();
        if(right != null)
            res += right.preoderTraversal();

        return res;
    }


    public static void main(String[] args) {
        Tree t1 = new Tree("c", null, null);
        t1 = t1.insert("g");
        t1 = t1.insert("e");
        t1 = t1.insert("a");
        t1 = t1.insert("y");
        t1 = t1.insert("t");
        System.out.println(t1.preoderTraversal());
        System.out.println(t1.height());
        //t1 = t1.remove("g");
        System.out.println(t1.preoderTraversal());
    }
}
