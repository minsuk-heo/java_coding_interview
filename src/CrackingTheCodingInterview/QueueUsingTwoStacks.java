package CrackingTheCodingInterview;

import java.util.Stack;

/**
 *
 * implement queue using two stacks
 *
 * Created by minsukheo on 1/14/17.
 */
public class QueueUsingTwoStacks {
    Stack<Integer> st1= new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();

    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
        queue.push(6);
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }

    private int pop() {
        if(!st2.isEmpty()) {
            return st2.pop();
        }
        else {
            while(!st1.isEmpty()) {
                st2.push(st1.pop());
            }
            if(st2.isEmpty()) {
                throw new java.util.NoSuchElementException();
            }
            return st2.pop();
        }
    }

    private void push(int item) {
        st1.push(item);
    }
}
