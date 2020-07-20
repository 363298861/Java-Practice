package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No113PathSumTwo {
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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        List<Integer> path = new ArrayList<>();
        pathSum(root, sum, list, path);
        return list;
    }

    public void pathSum(TreeNode root, int sum, List<List<Integer>> list, List<Integer> path){
        if(root.left == null && root.right == null){
            if(root.val == sum){
                path.add(root.val);
                list.add(path);
            }
        }else if(root.left == null){
            path.add(root.val);
            pathSum(root.right, sum - root.val, list, path);
        }else if(root.right == null){
            path.add(root.val);
            pathSum(root.left, sum - root.val, list, path);
        }else{
            path.add(root.val);
            List<Integer> path2 = new ArrayList<>(path);
            pathSum(root.left, sum - root.val, list, path);
            pathSum(root.right, sum - root.val, list, path2);
        }
    }
}








