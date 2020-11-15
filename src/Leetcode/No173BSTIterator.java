package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No173BSTIterator {

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

    class BSTIterator {

        List<TreeNode> list;
        int index;

        public BSTIterator(TreeNode root) {
            index = 0;
            Stack<TreeNode> stack = new Stack<>();
            list = new ArrayList<>();
            TreeNode cur = root;
            while(cur != null || !stack.isEmpty()) {
                while (cur!= null) {
                    stack.add(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                list.add(cur);
                cur = cur.right;
            }
        }

        /** @return the next smallest number */
        public int next() {
            return list.get(index++).val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return index < list.size();
        }
    }

    class BSTIteratorModified{
        Stack<TreeNode> stack;
        public BSTIteratorModified(TreeNode root){
            stack = new Stack<>();
            TreeNode ptr = root;
            addLeft(root, stack);
        }

        public int next(){
            TreeNode tn = stack.pop();
            addLeft(tn.right, stack);
            return tn.val;
        }

        public boolean hasNext(){
            return !stack.isEmpty();
        }

        private void addLeft(TreeNode root, Stack<TreeNode> s){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
        }
    }

}
