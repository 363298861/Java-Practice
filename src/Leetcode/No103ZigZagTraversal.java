package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No103ZigZagTraversal {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        zigzagLevelOrder(root, list, 0);
        return list;
    }

    public void zigzagLevelOrder(TreeNode root, List<List<Integer>> list, int level){
        if(root == null) return;
        if(list.size() <= level)
            list.add(new ArrayList<>());
        if(level % 2 == 0)
            list.get(level).add(root.val);
        else
            list.get(level).add(0, root.val);
        zigzagLevelOrder(root.left, list, level + 1);
        zigzagLevelOrder(root.right, list, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrderIterative(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        queue.add(root);
        int l = 0;
        while(!queue.isEmpty()){
            List<Integer> l1 = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode t = queue.poll();
                if(l % 2 == 0)
                    l1.add(t.val);
                else
                    l1.add(0, t.val);
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
            list.add(l1);
            l++;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        No103ZigZagTraversal z = new No103ZigZagTraversal();
        System.out.println(z.zigzagLevelOrderIterative(t));
    }
}
