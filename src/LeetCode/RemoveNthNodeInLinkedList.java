package LeetCode;

/**
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Created by minsukheo on 1/28/17.
 */
public class RemoveNthNodeInLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        RemoveNthNodeInLinkedList r = new RemoveNthNodeInLinkedList();
        ListNode result = r.removeNthFromEnd(head, 2);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=0; i<=n; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
