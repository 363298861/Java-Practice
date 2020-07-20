package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No98ValidateBST {

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

    public boolean isValidBST(TreeNode root, Integer max, Integer min) {
        if(root == null) return true;
        boolean res = true;
        if(min != null) res = root.val > min;
        if(max != null) res = res && root.val < max;
        res = res && isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
        return res;
    }

    public boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    public boolean isValidBSTIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre != null && cur.val <= pre.val) return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}













