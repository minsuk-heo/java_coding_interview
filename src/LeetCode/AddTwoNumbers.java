package LeetCode;

/**
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 * Created by minsukheo on 1/28/17.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = atn.addTwoNumbers(l1,l2);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode cur = result;
        int carry = 0;
        while(l1 != null && l2 != null) {
            cur.next = new ListNode((l1.val+l2.val+carry) % 10);
            carry = (l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while(l1 != null) {
            cur.next = new ListNode((l1.val+carry) % 10);
            cur = cur.next;
        }
        while(l2 != null) {
            cur.next = new ListNode((l2.val+carry) % 10);
            cur = cur.next;
        }

        if(carry > 0) {
            cur.next = new ListNode(carry);
            cur = cur.next;
        }

        return result.next;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }