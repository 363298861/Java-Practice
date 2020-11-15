package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No230KthSmallestBST {

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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            if(list.size() == k) return cur.val;
            cur = cur.right;
        }
        return 0;
    }
}
