package Leetcode;

public class No110BalancedBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
