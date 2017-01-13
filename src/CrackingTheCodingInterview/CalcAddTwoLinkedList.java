package CrackingTheCodingInterview;

/**
 *
 * Linked List
 * input: 7-1-6, 5-9-2 # 617 + 295
 * output: 912
 * add two linked list and return int value
 *
 * Created by Minsuk_Heo on 1/12/2017.
 */
public class CalcAddTwoLinkedList {
    public static void main(String[] args) {
        CalcAddTwoLinkedList solution = new CalcAddTwoLinkedList();
        // 7-1-6
        Node5 l1 = new Node5(7);
        l1.next = new Node5(1);
        l1.next.next = new Node5(6);

        // 5-9-2
        Node5 l2 = new Node5(5);
        l2.next = new Node5(9);
        l2.next.next = new Node5(2);

        System.out.println(solution.run(l1, l2));
    }

    private int run(Node5 l1, Node5 l2) {
        Node5 l3 = new Node5(0);
        Node5 cur = l3;

        int carry = 0;
        while(l1 != null && l2 != null) {
            cur.next = new Node5(((l1.val + l2.val) % 10) + carry);
            carry = (l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while(l1 != null) {
            l3.next = new Node5(l1.val + carry);
            carry = 0;
            l1 = l1.next;
            cur = cur.next;
        }
        while(l2 != null) {
            l3.next = new Node5(l2.val + carry);
            carry = 0;
            l2 = l2.next;
            cur = cur.next;
        }
        // we now will reverse l3, ignore first node since it is dummy
        cur = l3;
        Node5 prev = null;
        Node5 next = null;

        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        l3 = prev;
        StringBuilder sb = new StringBuilder();
        while(l3.next != null) {
            sb.append(l3.val);
            l3 = l3.next;
        }

        return Integer.parseInt(sb.toString());
    }

}

class Node5{
    int val;
    Node5 next;
    Node5(int n){
        val = n;
    }
}
