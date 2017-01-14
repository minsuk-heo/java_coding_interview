package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * set of stacks
 * push and pop
 * when stack is full, add one more stack and push to added stack
 * when stack is empty, remove empty stack and use previous stack.
 *
 * Created by minsukheo on 1/13/17.
 */
public class SetOfStacks {
    List<Stack> stackList = new ArrayList<Stack>();
    static final int STACK_MAX_ITEM = 3;
    SetOfStacks() {
        stackList.add(new Stack<Integer>());
    }
    public static void main(String[] args) {
        SetOfStacks stack = new SetOfStacks();
        for(int i=0;i<10;i++) {
            stack.push(i);
        }
        for(int i=0;i<10;i++) {
            System.out.println(stack.pop());
        }

    }

    private void push(int item) {
        Stack st = stackList.get(stackList.size()-1);
        if(st.size() < STACK_MAX_ITEM) {
            st.push(item);
        }
        else {
            Stack<Integer> newStack = new Stack<Integer>();
            System.out.println("adding new stack");
            newStack.push(item);
            stackList.add(newStack);
        }
    }

    private int pop() {
        Stack<Integer> st = stackList.get(stackList.size()-1);
        if(st.isEmpty()) {
            System.out.println("removing empty stack");
            stackList.remove(stackList.size()-1);
            st = stackList.get(stackList.size()-1);

        }
        return st.pop();
    }
}