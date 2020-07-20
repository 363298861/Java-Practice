package Leetcode;

import java.util.Stack;

public class No129SumRootToLeaf {
    int sum = 0;
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

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, "");
        return sum;
    }

    public void sumNumbers(TreeNode root, String n){
        String tmp;
        if(root == null) {
            return;
        }else if(root.left == null && root.right == null){
            tmp = n + root.val;
            sum += Integer.parseInt(tmp);
            return;
        }
        tmp = n + root.val;
        sumNumbers(root.left, tmp);
        sumNumbers(root.right, tmp);
    }

//    public int sumNumbersIterative(TreeNode root){
//        if(root == null) return 0;
//        Stack<Integer> sumTree = new Stack<>();
//        Stack<TreeNode> treeNodes = new Stack<>();
//        sumTree.add(root.val);
//        treeNodes.add(root);
//        int sum = 0;
//        while(!treeNodes.isEmpty()){
//
//        }
//    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(0);
        t.right = new TreeNode(5);
        No129SumRootToLeaf n = new No129SumRootToLeaf();
        System.out.println(n.sumNumbers(t));
    }
}
