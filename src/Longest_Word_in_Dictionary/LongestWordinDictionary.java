package Longest_Word_in_Dictionary;

import java.util.*;

class TrieNode {
    TrieNode[] childNode;
    boolean isWord;
    boolean happy;

    TrieNode() {
        this.childNode = new TrieNode[26];
        this.isWord = false;
        this.happy = false;
    }
}

class Trie {
    TrieNode root;
    int maxLen;
    Queue<String> candidates;

    Trie() {
        this.root = new TrieNode();
        this.root.isWord = true;
        this.root.happy = true;
        this.maxLen = 0;
        this.candidates = new LinkedList<>();
    }

    public void insertWord(String word) {
        TrieNode prev = null;
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.childNode[c - 'a'] == null) {
                curr.childNode[c - 'a'] = new TrieNode();
            }
            prev = curr;
            curr = curr.childNode[c - 'a'];
        }
        curr.isWord = true;
        if (prev.isWord && prev.happy) {
            curr.happy = true;
            this.maxLen = Math.max(this.maxLen, word.length());
            candidates.add(word);
            while(candidates.peek().length() < this.maxLen) {
                candidates.poll();
            }
        }
    }

    public String getLongestWord() {
        List<String> prev = new ArrayList<>(this.candidates);

        int i = 0;
        while(i < this.maxLen) {
            List<String> curr = new ArrayList<>();
            for (int j = 0; j < 26; j++) {
                char c = (char)(j + 'a');
                for (String s : prev) {
                    if (s.charAt(i) == c) {
                        curr.add(s);
                    }
                }
                if (curr.size() == 1) return curr.get(0);
                if (curr.size() > 0) break;
            }
            prev = curr;
            i++;
        }

        return "";
    }
}
public class LongestWordinDictionary {
    public String longestWord(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Trie trie = new Trie();
        for (String word : words) {
            trie.insertWord(word);
        }

        return trie.getLongestWord();
    }
}
