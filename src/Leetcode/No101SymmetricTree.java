package Leetcode;

import java.util.Stack;

public class No101SymmetricTree {
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

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null || t1.val != t2.val)
            return false;
        if((t1.left == null && t2.right != null) || (t1.left != null && t2.right == null) || (t1.left != null && t1.left.val != t2.right.val))
            return false;
        if((t2.left == null && t1.right != null) || (t2.left != null && t1.right == null) || (t2.left != null && t2.left.val != t1.right.val))
            return false;
        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }

    public boolean isSymmetricModified(TreeNode t1, TreeNode t2){
        if(t1 == null || t2 == null)
            return t1 == t2;
        if(t1.val != t2.val) return false;
        return isSymmetricModified(t1.left, t2.right) && isSymmetricModified(t1.right, t2.left);
    }

    public boolean isSymmetricIterative(TreeNode root){
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.empty()){
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            if(t1 == null && t2 == null)
                continue;
            if(t1 == null || t2 == null || t1.val != t2.val) return false;
            stack.push(t1.left);
            stack.push(t2.right);
            stack.push(t2.left);
            stack.push(t1.right);
        }
        return true;
    }
}











