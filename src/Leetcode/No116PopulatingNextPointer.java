package Leetcode;

import Project_Euler.No1;

import java.util.LinkedList;
import java.util.Queue;

public class No116PopulatingNextPointer {
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
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.next = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                node.next = pre;
                if(node.left != null) {
                    queue.add(node.right);
                    queue.add(node.left);
                }
                pre = node;
            }
        }
        return root;
    }

    public Node connectModified(Node root){
        if(root == null) return null;
        Node pre = root;
        Node cur = null;
        while(pre.left != null){
            cur = pre;
            while(cur != null){
                cur.left.next = cur.right;
                if(cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }
}
