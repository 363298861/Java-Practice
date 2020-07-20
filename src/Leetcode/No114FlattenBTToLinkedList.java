package Leetcode;

public class No114FlattenBTToLinkedList {

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

    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode r = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode leaf = root.right;
        if(leaf == null) root.right = r;
        else{
            while(leaf.right != null)
                leaf = leaf.right;
            leaf.right = r;
        }
        flatten(root.right);
    }

    public void flatten2(TreeNode root){
        flatten(root, null);
    }

    public TreeNode flatten(TreeNode root, TreeNode pre){
        if(root == null) return pre;
        pre = flatten(root.right, pre);
        pre = flatten(root.left, pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }

}
