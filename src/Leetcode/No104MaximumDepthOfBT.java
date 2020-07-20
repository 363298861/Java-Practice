package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No104MaximumDepthOfBT {

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

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthIterative(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int s = queue.size();
            for(int i = 0; i < s; i++){
                TreeNode t = queue.poll();
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
            depth++;
        }
        return depth;
    }
}
