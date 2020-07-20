package Leetcode;

import edu.princeton.cs.algs4.Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No107BTLevelTraversal {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrderBottom(root, list, 0);
        Collections.reverse(list);
        return list;
    }

    public void levelOrderBottom(TreeNode t, List<List<Integer>> list, int level) {
        if(t == null) return;
        if(level >= list.size()){
            list.add(new ArrayList<>());
        }
        list.get(level).add(t.val);
        levelOrderBottom(t.left, list, level + 1);
        levelOrderBottom(t.right, list, level + 1);
    }
}
