package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No94TreeTraversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.empty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode t = stack.pop();
            res.add(t.val);
            root = t.right;
        }
        return res;
    }
}
