package CrackingTheCodingInterview;

/**
 *
 * Array has three stacks inside,
 * User will use three stacks without knowing the three stacks are in one array
 * implement pushStack1, pushStack2, pushStack3, popStack1, popStack2, popStack3.
 *
 * Created by Minsuk_Heo on 1/12/2017.
 */
public class ThreeStacksInArray {
    private int[] array;
    int st1ptr, st2ptr, st3ptr, capacity;

    ThreeStacksInArray(int capacity) {
        // stack1, stack2, and stack3 will have given capacity
        array = new int[capacity * 3];
        // each stack pointer(ptr) will be initialized
        st1ptr = 0;
        st2ptr = capacity;
        st3ptr = capacity*2;
        this.capacity = capacity;
    }

    private void pushStack1(int i) {
        if(st1ptr < capacity) {
            push(i, st1ptr++);
        }
        else {
            System.out.println("stack1 is full");
        }
    }

    private void pushStack2(int i) {
        if(st2ptr < capacity*2) {
            push(i, st2ptr++);
        }
        else {
            System.out.println("stack2 is full");
        }
    }

    private void pushStack3(int i) {
        if(st3ptr < capacity*3) {
            push(i, st3ptr++);
        }
        else {
            System.out.println("stack3 is full");
        }
    }

    private int popStack1() {
        if(st1ptr > 0) {
            return pop(--st1ptr);
        }
        else {
            System.out.println("stack1 is empty");
            throw new java.util.NoSuchElementException();
        }
    }

    private int popStack2() {
        if(st2ptr > capacity) {
            return pop(--st2ptr);
        }
        else {
            System.out.println("stack2 is empty");
            throw new java.util.NoSuchElementException();
        }
    }

    private int popStack3() {
        if(st3ptr > capacity * 2) {
            return pop(--st3ptr);
        }
        else {
            System.out.println("stack3 is empty");
            throw new java.util.NoSuchElementException();
        }
    }

    private int pop(int ptr) {
        return array[ptr];
    }

    private void push(int val, int ptr) {
        array[ptr] = val;
    }

    public static void main(String[] args) {
        ThreeStacksInArray solution = new ThreeStacksInArray(2);
        solution.pushStack1(1);
        solution.pushStack1(2);

        solution.pushStack2(3);
        solution.pushStack2(4);

        solution.pushStack3(5);
        solution.pushStack3(6);

        System.out.println(solution.popStack1());
        System.out.println(solution.popStack1());
        System.out.println(solution.popStack2());
        System.out.println(solution.popStack2());
        System.out.println(solution.popStack3());
        System.out.println(solution.popStack3());
    }
}
