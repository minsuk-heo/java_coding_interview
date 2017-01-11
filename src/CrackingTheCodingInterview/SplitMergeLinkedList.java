package CrackingTheCodingInterview;

/**
 *
 * Linked List
 * input: 6-3-8-1-5-9,5
 * output: 3-1-5-6-8-9
 * sort linked list with a key
 *
 * Created by minsukheo on 1/10/17.
 */
public class SplitMergeLinkedList {
    public static void main(String[] args) {

        Node4 input = new Node4(6);
        input.next =  new Node4(3);
        input.next.next =  new Node4(8);
        input.next.next.next =  new Node4(1);
        input.next.next.next.next =  new Node4(5);
        input.next.next.next.next.next =  new Node4(9);

        SplitMergeLinkedList solution = new SplitMergeLinkedList();
        Node4 output = solution.run(input, 5);

        while(output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

    private Node4 run(Node4 input, int pivot) {
        Node4 less = new Node4(0);
        Node4 greater = new Node4(0);
        Node4 less_cur;
        Node4 greater_cur;
        Node4 cur = input;

        while(cur != null) {
            less_cur = less;
            greater_cur = greater;
            if(cur.val < pivot) {
                while(less_cur.next != null) {
                    less_cur = less_cur.next;
                }
                less_cur.next = new Node4(cur.val);
            }
            else if(cur.val > pivot){
                while(greater_cur.next != null) {
                    greater_cur = greater_cur.next;
                }
                greater_cur.next = new Node4(cur.val);
            }
            cur = cur.next;
        }
        less_cur = less;
        while(less_cur.next != null) {
            less_cur = less_cur.next;
        }
        less_cur.next = new Node4(pivot);
        less_cur.next.next = greater.next;
        return less.next;
    }
}

class Node4{
    int val;
    Node4 next;
    Node4(int n){
        val = n;
    }
}