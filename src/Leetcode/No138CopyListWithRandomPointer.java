package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No138CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node pointer = head;

        while(pointer != null){
            map.put(pointer, new Node(pointer.val));
            pointer = pointer.next;
        }

        pointer = head;
        while(pointer != null){
            map.get(pointer).next = map.get(pointer.next);
            map.get(pointer).random = map.get(pointer.random);
            pointer = pointer.next;
        }

        return map.get(head);
    }

    public Node copyRandomListModified(Node head){

        Node pointer = head;
        while(pointer != null){
            Node tmp = new Node(pointer.val);
            tmp.next = pointer.next;
            pointer.next = tmp;
            pointer = tmp.next;
        }
        pointer = head;
        while(pointer != null){
            if(pointer.random != null){
                pointer.next.random = pointer.random.next;
            }else{
                pointer.next.random = null;
            }
            pointer = pointer.next.next;
        }

        pointer = head;
        Node newHead = head.next;
        Node newPointer = newHead;

        while(head != null){
            head.next = head.next.next;
            if(newPointer.next != null)
                newPointer.next = newPointer.next.next;
            head = head.next;
            newPointer = newPointer.next;
        }
        return newHead;
    }
}
