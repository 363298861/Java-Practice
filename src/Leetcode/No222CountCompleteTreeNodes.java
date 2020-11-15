package Leetcode;

public class No222CountCompleteTreeNodes {
    public static class TreeNode {
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

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int height(TreeNode root){
        return root == null ? -1 : 1 + height(root.left);
    }

    public int countNodes2(TreeNode root){
        int h = height(root);
        if(h < 0){
            return 0;
        }else{
            if(height(root.right) == h - 1){
                return (1 << h) + countNodes2(root.right);
            }else{
                return (1 << h - 1) + countNodes2(root.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        No222CountCompleteTreeNodes n = new No222CountCompleteTreeNodes();
        System.out.println(n.countNodes2(t));

    }
}
