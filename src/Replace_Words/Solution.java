package Replace_Words;

import java.util.List;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();

        for(String word : dictionary) {
            trie.insertWord(word);
        }

        String[] wordsInSentence = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String wordInSentence : wordsInSentence) {
            result.append(trie.getRoot(wordInSentence)).append(" ");
        }

        return result.substring(0, result.length() - 1);
    }
}

class Trie {
    TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode curr = this.root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.childNode[c - 'a'] == null) {
                curr.childNode[c - 'a'] = new TrieNode();
            }
            curr = curr.childNode[c - 'a'];
        }
        curr.isWord = true;
        curr.whichWord = word;
    }

    public String getRoot(String word) {
        TrieNode curr = this.root;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.childNode[c - 'a'] == null) {
                return word;
            }
            curr = curr.childNode[c - 'a'];
            if (curr.isWord) {
                return curr.whichWord;
            }
        }

        return word;
    }
}

class TrieNode {
    TrieNode[] childNode;
    boolean isWord;
    String whichWord;

    TrieNode() {
        this.childNode = new TrieNode[26];
        this.isWord = false;
        this.whichWord = "";
    }
}
