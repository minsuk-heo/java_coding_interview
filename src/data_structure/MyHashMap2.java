package data_structure;

/**
 * Created by minsukheo on 1/13/17.
 */
public class MyHashMap2 {
    private int hashSize;
    private hashItem[] hash;
    public MyHashMap2(int size) {
        hashSize = size;
        hash = new hashItem[hashSize];
        for(int i=0;i<size;i++) {
            hash[i] = null;
        }
    }

    public static void main(String[] args) {
        MyHashMap2 myHashMap = new MyHashMap2(10);
        myHashMap.put(1,100);
        myHashMap.put(2,200);
        myHashMap.put(10,300);
        myHashMap.put(11,400);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(10));
        System.out.println(myHashMap.get(11));
    }

    private int get(int key) {
        int hashIndex = key % hashSize;


        while(hash[hashIndex] != null && hash[hashIndex].key != key) {
            hashIndex++;
        }
        if(hash[hashIndex] == null) {
            throw new java.util.NoSuchElementException();
        }
        else {
            return hash[hashIndex].val;
        }

    }

    private void put(int key, int val) {
        int hashIndex = key % hashSize;
        while(hash[hashIndex] != null && hash[hashIndex].val != val) {
            hashIndex++;
        }
        hash[hashIndex] = new hashItem(key, val);
    }
}

class hashItem{
    int key;
    int val;

    hashItem(int key, int val) {
        this.key = key;
        this.val = val;
    }

    int getKey(){
        return key;
    }

    int getVal(){
        return val;
    }
}
