package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No257BinaryTreePath {
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        dps(root, list, "");
        return list;
    }

    public void dps(TreeNode root, List<String> list, String s){
        if(root == null) return;
        String t;
        if(s.isEmpty())
            t = root.val + "";
        else
            t = s + "->" + root.val;
        if(root.left == null && root.right == null){
            list.add(t);
        }else if(root.left == null){
            dps(root.right, list, t);
        }else if(root.right == null){
            dps(root.left, list, t);
        }else{
            dps(root.left, list, t);
            dps(root.right, list, t);
        }
    }

    public List<String> binaryTreePathsIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        String s = "";
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        while(t != null || !stack.isEmpty()){
            while(t != null){
                s += "->" + t.val;
                stack.push(t);
                t = t.left;
            }
            t = stack.pop();
            t = t.right;
            if(t == null)
                list.add(s.substring(2));
        }
        return list;
    }
}
