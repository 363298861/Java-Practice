package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No199BinaryTreeRightSightView {

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

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        queue.offer(root);
        while(!queue.isEmpty()){
            int l = queue.size();
            for(int i = 0; i < l; i++){
                TreeNode t = queue.poll();
                if(t.left != null)
                    queue.offer(t.left);
                if(t.right != null)
                    queue.offer(t.right);
                if(i == l - 1)
                    list.add(t.val);
            }
        }
        return list;
    }
}
