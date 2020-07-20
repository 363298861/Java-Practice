package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No111MinimumDepth {
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

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left != null && root.right == null)
            return 1 + minDepth(root.left);
        if(root.right != null && root.left == null)
            return 1 + minDepth(root.right);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public int minDepthIterative(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0; i < size; i++){
                TreeNode t = queue.poll();
                if(t.left == null && t.right == null) return depth;
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
        }
        return depth;
    }
}
