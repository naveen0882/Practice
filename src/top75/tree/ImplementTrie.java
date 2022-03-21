package tree;

import java.util.HashMap;

/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and 
retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

 */

class TrieNode {
    HashMap<Character, TrieNode> map;
    char character;
    boolean last;
    
    // Initialize your data structure here.
    public TrieNode(char character) {
        this.map = new HashMap<Character, TrieNode>();
        this.character = character;
        this.last = false;
    }
}

public class ImplementTrie {
    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode(' ');
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
            
        for(char c : word.toCharArray()) {
            if(!current.map.containsKey(c)) {
                current.map.put(c, new TrieNode(c));
            }
            
            current = current.map.get(c);
        }
        
        current.last = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode current = root;
        
        for(char c : word.toCharArray()) {
            if(!current.map.containsKey(c)) {
                return false;
            }

            current = current.map.get(c);
        }
        
        if(current.last == true) {
            return true;
        } else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        
        for(char c : prefix.toCharArray()) {
            if(!current.map.containsKey(c)) {
                return false;
            }
            
            current = current.map.get(c);
        }
        
        return true;
    }
}
