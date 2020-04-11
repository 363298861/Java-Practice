package Leetcode;

public class No100SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(q == null || p == null)
            return false;
        else{
            return q.val == p.val && isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
        }
    }

    public boolean improved(TreeNode p, TreeNode q){
        if(q == null || p == null)
            return q == p;
        else{
            return q.val == p.val && isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
        }
    }
}
