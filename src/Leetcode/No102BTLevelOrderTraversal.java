package Leetcode;

import java.util.*;

public class No102BTLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrder(root, list, 0);
        return list;
    }

    public void levelOrder(TreeNode root, List<List<Integer>> list, int level){
        if(root == null) return;
        if(list.size() <= level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        levelOrder(root.left, list, level + 1);
        levelOrder(root.right, list, level + 1);
    }

    public List<List<Integer>> levelOrderIterative(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int n = queue.size();
            for(int i = 0; i < n; i++){
                TreeNode t = queue.poll();
                l.add(t.val);
                if(t.left != null)
                    queue.add(t.left);
                if(t.right != null)
                    queue.add(t.right);
            }
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        No102BTLevelOrderTraversal n = new No102BTLevelOrderTraversal();
        System.out.println(n.levelOrderIterative(t));
    }
}
