package Leetcode;

public class No108ConvertSortedArrayToBT {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end){
        if(start > end) return null;
        TreeNode t = new TreeNode(nums[(start + end) / 2]);
        t.left = build(nums, start, (start + end) / 2 - 1);
        t.right = build(nums, (start + end) / 2 + 1, end);
        return t;
    }
}
