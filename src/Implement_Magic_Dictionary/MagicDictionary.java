package Implement_Magic_Dictionary;

import java.util.ArrayList;
import java.util.List;

class MagicDictionary {
    TrieNode root;

    public MagicDictionary() {
        this.root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode curr = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.childNode[c - 'a'] == null) {
                    curr.childNode[c - 'a'] = new TrieNode();
                }
                curr = curr.childNode[c - 'a'];
                curr.whichWord.add(word.substring(i+1));
            }
            curr.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        TrieNode curr = this.root;

        for (int i = 0; i < searchWord.length(); i++) {
            if (this.changeOneWord(curr, searchWord, i)) {
                return true;
            } else {
                char c = searchWord.charAt(i);
                if (curr.childNode[c - 'a'] != null) {
                    curr = curr.childNode[c - 'a'];
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean changeOneWord(TrieNode curr, String s, int currIdx) {
        List<String> candidates = new ArrayList<>();
        for (int j = 0; j < 26; j++) {
            if (j != s.charAt(currIdx) - 'a' && curr.childNode[j] != null) {
                candidates.addAll(curr.childNode[j].whichWord);
            }
        }
        return candidates.contains(s.substring(currIdx+1));
    }
}

class TrieNode {
    TrieNode[] childNode;
    boolean isWord;
    List<String> whichWord;

    TrieNode() {
        this.childNode = new TrieNode[26];
        this.isWord = false;
        this.whichWord = new ArrayList<>();
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
