package leetcodeTest;

public class No98ValidateTree {
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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer lo, Integer hi){
        if(root == null)
            return true;
        if(lo != null && root.val <= lo)
            return false;
        if(hi != null && root.val >= hi)
            return false;
        if(root.left != null && root.left.val >= root.val)
            return false;
        if(root.right != null && root.right.val <= root.val)
            return false;
        return isValid(root.left, lo, root.val) && isValid(root.right, root.val, hi);
    }

    public static void main(String[] args) {

    }
}
