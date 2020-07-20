package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No98BTInorder {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while(curr != null || !stack.empty()){
            while(curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        t.left = new TreeNode(9);
        System.out.println(inorderTraversal(t));
    }
}




















