package CrackingTheCodingInterview;

/**
 * Created by minsukheo on 1/10/17.
 */
public class RemoveNodeInLinkedList {
    public static void main(String[] args) {
        RemoveNodeInLinkedList solution = new RemoveNodeInLinkedList();
        Node3 linkedlist = new Node3(1);
        linkedlist.next = new Node3(2);
        linkedlist.next.next = new Node3(3);
        linkedlist.next.next.next = new Node3(4);
        linkedlist.next.next.next.next = new Node3(5);

        linkedlist = solution.run(linkedlist, 2);
        while(linkedlist != null) {
            System.out.println(linkedlist.val);
            linkedlist = linkedlist.next;
        }
    }

    private Node3 run(Node3 head, int i) {
        Node3 cur = head;
        if(cur.val == i) {
            head = cur.next;
        }
        else {
            Node3 prev = cur;
            cur = cur.next;
            while(cur.val != i) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = cur.next;
            cur = null;
        }
        return head;
    }
}

class Node3{
    int val;
    Node3 next;
    Node3(int n){
        val = n;
        next = null;
    }
}
