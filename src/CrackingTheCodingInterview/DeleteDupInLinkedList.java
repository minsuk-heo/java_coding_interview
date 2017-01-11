package CrackingTheCodingInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by minsukheo on 1/10/17.
 */
public class DeleteDupInLinkedList {
    public static void main(String[] args) {
        DeleteDupInLinkedList solution = new DeleteDupInLinkedList();

        Node1 ll = new Node1(1);
        ll.next = new Node1(1);
        ll.next.next = new Node1(2);
        ll.next.next.next = new Node1(1);
        ll.next.next.next.next = new Node1(3);
        ll.next.next.next.next.next = new Node1(2);

        solution.run(ll);


    }

    private void run(Node1 node) {
        Map<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
        Node1 prev = null;
        Node1 cur = node;
        while(cur != null) {
            if(hash.containsKey(cur.val)){
                System.out.println(" linked list has dup: "+cur.val);
                prev.next = cur.next;
            }
            else {
                hash.put(cur.val, true);
                prev = cur;
            }
            cur = cur.next;
        }

        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

class Node1{
    int val;
    Node1 next;

    Node1(int n) {
        val = n;
        next = null;
    }
}
