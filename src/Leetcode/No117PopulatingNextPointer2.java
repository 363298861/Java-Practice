package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No117PopulatingNextPointer2 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node first = root;

        while(first != null || !queue.isEmpty()){
            int l = queue.size();
            first = queue.remove();
            Node next = null;
            for(int i = 0; i < l; i++){
                if(i != l - 1)
                    next = queue.poll();
                else
                    next = null;
                first.next = next;
                if(first.left != null) queue.add(first.left);
                if(first.right != null) queue.add(first.right);
                first = next;
            }
        }
        return root;
    }

    public Node connectModified(Node root){
        if(root == null) return null;

        Node cur;
        Node pre = root;
        while(pre != null){
            cur = pre;
            Node last = null;
            while(cur != null){
                if(cur.left != null && cur.right != null){
                    cur.left.next = cur.right;
                    last = cur.right;
                }else if(cur.left != null){
                    last = cur.left;
                }else if(cur.right != null){
                    last = cur.right;
                }
                if(cur.next != null){
                    if(last != null){
                        if(cur.next.left != null){
                            last.next = cur.next.left;
                        }else if(cur.next.right != null){
                            last.next = cur.next.right;
                        }
                    }
                }
                cur = cur.next;
            }
            while(pre != null) {
                if (pre.left != null){
                    pre = pre.left;
                    break;
                }else if(pre.right != null){
                    pre = pre.right;
                    break;
                }else{
                    pre = pre.next;
                }
            }
        }
        return root;
    }
}
