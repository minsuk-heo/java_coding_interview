package data_structure;

/**
 * Created by Minsuk_Heo on 1/7/2017.
 */
public class MyHashMap {
    private final static int TABLE_SIZE = 128;

    HashEntry[] table;

    MyHashMap() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++){
            table[i] = null;
        }

    }

    public int get(int key) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }

        if (table[hash] == null)
            return -1;
        else
            return table[hash].getValue();
    }

    public void put(int key, int value) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }

        table[hash] = new HashEntry(key, value);
    }

    public static void main(String[] args) {
        MyHashMap hm = new MyHashMap();
        hm.put(1,100);
        System.out.println(hm.get(1));
    }
}

class HashEntry {
    private int key;
    private int value;

    HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
