package CrackingTheCodingInterview;

/**
 *
 * Palindrome
 * a word, phrase, or sequence that reads the same backward as forward, e.g., madam or nurses run.
 * 1-3-5-3-1 is palindrome
 * 5-9-2 is not palindrome
 *
 * Created by Minsuk_Heo on 1/12/2017.
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();

        Node6 list1 = new Node6(1);
        list1.next = new Node6(3);
        list1.next.next = new Node6(5);
        list1.next.next.next = new Node6(3);
        list1.next.next.next.next = new Node6(1);

        Node6 list2 = new Node6(5);
        list2.next = new Node6(9);
        list2.next.next = new Node6(2);

        System.out.println(solution.run(list1));
        System.out.println(solution.run(list2));
    }

    private boolean run(Node6 list) {
        Node6 cur = list;
        Node6 prev = null;
        Node6 next = null;

        while(cur.next != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while(list != null) {
            sb1.append(list.val);
            list = list.next;
        }

        while(cur != null) {
            sb2.append(cur.val);
            cur = cur.next;
        }
        boolean result = sb1.toString().equals(sb2.toString()) ? true : false;

        return result;
    }
}

class Node6{
    int val;
    Node6 next;

    Node6(int n){
        val =n;
    }
}
