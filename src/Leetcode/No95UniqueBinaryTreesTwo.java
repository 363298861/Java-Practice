package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No95UniqueBinaryTreesTwo {
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

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = generateTrees(1, n);
        if (list.get(0) == null) {
            return new ArrayList<TreeNode>();
        } else {
            return list;
        }
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end) list.add(null);
        for(int idx = start; idx <= end; idx++){
            List<TreeNode> leftList = generateTrees(start, idx - 1);
            List<TreeNode> rightList = generateTrees(idx + 1, end);
            for(TreeNode left : leftList){
                for(TreeNode right : rightList){
                    TreeNode root = new TreeNode(idx);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
