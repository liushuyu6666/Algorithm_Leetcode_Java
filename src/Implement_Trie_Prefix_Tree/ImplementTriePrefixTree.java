package Implement_Trie_Prefix_Tree;

public class ImplementTriePrefixTree {
    private TrieNode root;

    public ImplementTriePrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.childNode[c - 'a'] == null) {
                curr.childNode[c - 'a'] = new TrieNode();
            }
            curr = curr.childNode[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.childNode[c - 'a'] == null) {
                return false;
            } else {
                curr = curr.childNode[c - 'a'];
            }
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.childNode[c - 'a'] == null) {
                return false;
            } else {
                curr = curr.childNode[c - 'a'];
            }
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] childNode;
    boolean isWord;

    TrieNode() {
        this.childNode = new TrieNode[26];
        this.isWord = false;
    }
}
