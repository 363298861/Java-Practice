package Leetcode;

public class No235LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(isDescendant(root.left, p) && isDescendant(root.left, q))
            return lowestCommonAncestor(root.left, p, q);
        if(isDescendant(root.right, p) && isDescendant(root.right, q))
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    private boolean isDescendant(TreeNode root, TreeNode t){
        if(root == null) return false;
        if(root == t) return true;
        return isDescendant(root.left, t) || isDescendant(root.right, t);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == q || root == p) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
