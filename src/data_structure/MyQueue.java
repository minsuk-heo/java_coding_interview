package data_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Minsuk_Heo on 1/1/2017.
 */
public class MyQueue {
    private List<Integer> queue = new ArrayList<Integer>();

    public void enqueue(Integer n) {
        queue.add(n);
    }

    public Integer dequeue() {
        if(queue.isEmpty()) {
            System.out.println("queue is empty");
            throw new java.util.NoSuchElementException();
        }
        return queue.remove(0);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {

        MyQueue mq = new MyQueue();

        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        mq.enqueue(4);

        while(!mq.isEmpty()){
            System.out.println(mq.dequeue());
        }
    }
}


