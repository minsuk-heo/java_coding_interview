package CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * stack has min function O(1)
 *
 * Created by minsukheo on 1/13/17.
 */
public class PushPopMinStack {
    int stackSize;
    int[] stack;
    int top;
    int min;
    List<Integer> minList = new ArrayList<Integer>();

    PushPopMinStack(int size) {
        stackSize = size;
        stack = new int[stackSize];
        top = 0;
    }
    public static void main(String[] args) {
        PushPopMinStack st = new PushPopMinStack(10);
        st.push(3);
        st.push(5);
        st.push(2);
        st.push(7);
        st.push(1);
        System.out.println("minimum is : "+st.getMinimumValue());
        System.out.println(st.pop());
        System.out.println("minimum is : "+st.getMinimumValue());
        System.out.println(st.pop());
        System.out.println("minimum is : "+st.getMinimumValue());
        System.out.println(st.pop());
        System.out.println("minimum is : "+st.getMinimumValue());
        System.out.println(st.pop());
        System.out.println("minimum is : "+st.getMinimumValue());
        System.out.println(st.pop());
    }

    private int pop() {
        if(top > 0) {
            if(stack[top-1] == min) {
                minList.remove(minList.size()-1);
                if(minList.size() > 0) {
                    min = minList.get(minList.size()-1);
                }
                else {
                    min = -1;
                }

            }
            return stack[--top];
        }
        else {
            throw new java.util.NoSuchElementException();
        }
    }

    private void push(int item) {
        if(top < stackSize) {
            stack[top++] = item;

            if(minList.isEmpty()) {
                min = item;
                minList.add(item);
            }
            else {
                if(min > item) {
                    min = item;
                    minList.add(item);
                }
            }
        }
        else {
            System.out.println("stack is full");
        }
    }

    public int getMinimumValue() {
        return min;
    }
}
