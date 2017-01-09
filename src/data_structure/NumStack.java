package data_structure;

/**
 * Created by Minsuk_Heo on 1/7/2017.
 */
public class NumStack {
    private int[] arr;
    private int top = 0;
    public NumStack(int stackSize) {
        this.arr = new int[stackSize];
    }

    public static void main(String[] args) {
        NumStack st = new NumStack(3);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st.pop());
        System.out.println(st.pop());
    }

    private int peek() {
        return arr[top-1];
    }

    private int pop() {
        if(top > 0) {
            return arr[--top];
        }
        else {
            throw new java.util.NoSuchElementException();
        }
    }

    private void push(int i) {
        if(top < arr.length) {
            arr[top++] = i;
            System.out.println("pushed: "+i);
        }
        else {
            System.out.println("stack is full");
        }
    }
}
