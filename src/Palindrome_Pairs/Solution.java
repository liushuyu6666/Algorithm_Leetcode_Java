package Palindrome_Pairs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        // Build the tree
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insertWord(words[i], i);
        }

        // Traverse all words
        List<Integer> pairs;
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result;
        for(int i = 0; i < words.length; i++) {
            pairs = trie.findPair(words[i]);
            for (Integer pair : pairs) {
                if (pair != i) {
                    result = new ArrayList<Integer>();
                    result.add(i);
                    result.add(pair);
                    results.add(result);
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = new String[]{"a","aa"};
        System.out.println(s.palindromePairs(words));
    }
}

class Trie {
    TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word, int wordIndex) {
        TrieNode curr = this.root;
        String revWord = new StringBuilder(word).reverse().toString();

        for (int i = 0; i < revWord.length(); i++) {
            char c = revWord.charAt(i);
            if (curr.childNode[c - 'a'] == null) {
                curr.childNode[c - 'a'] = new TrieNode();
            }
            if (isPalindrome(revWord.substring(i))) {
                curr.isPalindrome.add(wordIndex);
            }
            curr = curr.childNode[c - 'a'];
        }
        curr.whichWord = wordIndex;
    }

    public List<Integer> findPair(String word) {
        TrieNode curr = this.root;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            // condition_1: word is longer and the combination is long + short.
            if (curr.whichWord != -1 && this.isPalindrome(word.substring(i))) {
                result.add(curr.whichWord);
            }
            char c = word.charAt(i);
            if (curr.childNode[c - 'a'] != null) {
                curr = curr.childNode[c - 'a'];
            } else {
                return result;
            }
        }
        // condition_0: combination is same length + same length
        if (curr.whichWord != -1) {
            result.add(curr.whichWord);
        }

        result.addAll(curr.isPalindrome);
        return result;
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while(i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] childNode;
    int whichWord;
    List<Integer> isPalindrome;

    TrieNode() {
        this.childNode = new TrieNode[26];
        this.isPalindrome = new ArrayList<Integer>();
        this.whichWord = -1;
    }
}

