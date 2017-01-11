package CrackingTheCodingInterview;

/**
 * Created by minsukheo on 1/10/17.
 */
public class KthFromLastNodeInLinkedList {
    public static void main(String[] args) {
        KthFromLastNodeInLinkedList solution = new KthFromLastNodeInLinkedList();
        Node2 ll = new Node2(1);
        ll.next = new Node2(2);
        ll.next.next = new Node2(3);
        ll.next.next.next = new Node2(4);
        ll.next.next.next.next = new Node2(5);

        solution.run(ll, 0);
        solution.run(ll, 1);
        solution.run(ll, 2);
        solution.run(ll, 3);
        solution.run(ll, 4);

    }

    private void run(Node2 node, int nth) {
        Node2 fast = node;
        Node2 slow = node;

        for(int i=0;i<nth;i++){
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        System.out.println(nth+"th item from last node in the linked list : "+slow.val);

    }
}

class Node2{
    int val;
    Node2 next;

    Node2(int n){
        this.val = n;
        next = null;
    }
}
