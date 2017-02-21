package data_structure;

import java.util.HashMap;

/**
 * Created by minsukheo on 2/20/17.
 */
public class Trie {
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.isLast = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null) {
                return false;
            }
            current = node;
        }

        return current.isLast;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("help");

        System.out.println(trie.search("bye"));
        System.out.println(trie.search("hell"));
        System.out.println(trie.search("help"));
        System.out.println(trie.search("hello"));
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isLast;

    TrieNode(){
        children = new HashMap<Character, TrieNode>();
        isLast = false;
    }
}
