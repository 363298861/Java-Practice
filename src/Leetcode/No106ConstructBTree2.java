package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No106ConstructBTree2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,  int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map){
        if(inEnd < inStart || postEnd < postStart) return null;
        TreeNode t = new TreeNode(postorder[postEnd]);
        int leftChildren = map.get(t.val) - inStart;
        t.left = buildTree(inorder, inStart, inStart + leftChildren - 1, postorder, postStart, postStart + leftChildren - 1, map);
        t.right = buildTree(inorder, map.get(t.val) + 1, inEnd, postorder, postStart + leftChildren, postEnd - 1, map);

        return t;
    }
}
