package advanced;

import java.util.HashMap;

/**
 * Created by minsukheo on 2/20/17.
 */
public class LRUCache {
    int capacity;
    int count;
    DLinkedNode head;
    DLinkedNode tail;
    HashMap<Integer, DLinkedNode> cache = new HashMap<>();

    LRUCache(int capa) {
        capacity = capa;
        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.pre = null;
        head.post = tail;

        tail.pre = head;
        tail.post = null;

        cache = new HashMap<>();

    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }

    public void set(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null){

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity){
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else{
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.set(1,1);
        lru.set(2,2);
        lru.set(3,3);
        lru.set(1,1);
        lru.set(4,4);
        System.out.println(lru.get(1));
    }
}

class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
}