package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No112PathSum {

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

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.val == sum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSumIterative(TreeNode root, int sum){
        if(root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        int s = 0;
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.add(cur);
                s += cur.val;
                cur = cur.left;
            }
            cur = stack.pop();
            int tmp = cur.val;
            if(cur.left == null && cur.right == null && s == sum) return true;
            if(cur.right == null) s -= tmp;
            cur = cur.right;
        }
        return false;
    }
}
