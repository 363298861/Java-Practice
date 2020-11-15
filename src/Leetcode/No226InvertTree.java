package Leetcode;

public class No226InvertTree {

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

        @Override
        public String toString() {
            String res = "";
            if(left != null)
                res += left;
            res += val + ", ";
            if(right != null)
                res += right;
            return res;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode ptr = root.right;
        root.right = root.left;
        root.left = ptr;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(7);
        System.out.println(t);
        No226InvertTree n = new No226InvertTree();
        TreeNode r = n.invertTree(t);
        System.out.println(r);
    }
}
