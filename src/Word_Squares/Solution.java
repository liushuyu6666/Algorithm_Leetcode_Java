package Word_Squares;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Trie {
    TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode curr = this.root;
        curr.allWords.add(word);

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.childNode[c - 'a'] == null) {
                curr.childNode[c - 'a'] = new TrieNode();
            }
            curr = curr.childNode[c - 'a'];
            curr.allWords.add(word);
        }
        curr.isWord = true;
    }

    public void dfs(String prefix, Stack<String> stack, List<List<String>> results, int wordLen) {
        TrieNode curr = this.root;

        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.childNode[c - 'a'] != null) {
                curr = curr.childNode[c - 'a'];
            } else {
                stack.pop();
                return;
            }
        }
        ArrayList<String> candidates = curr.allWords;

        for(String candidate : candidates) {
            stack.add(candidate);
            if (stack.size() == wordLen) {
                List<String> result = new ArrayList<String>(stack);
                results.add(result);
                stack.pop();
            } else {
                // Caveat: It should be if - else condition
                dfs(this.getPrefix(stack), stack, results, wordLen);
            }
        }

        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    private String getPrefix(Stack<String> stack) {
        int len = stack.size();
        String prefix = "";

        for (String str : stack) {
            prefix += str.charAt(len);
        }

        return prefix;
    }
}

class TrieNode {
    TrieNode[] childNode;
    boolean isWord;
    ArrayList<String> allWords;

    TrieNode() {
        this.childNode = new TrieNode[26];
        this.isWord = false;
        this.allWords = new ArrayList<>();
    }
}
class Solution {
    public List<List<String>> wordSquares(String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insertWord(word);
        }

        List<List<String>> results = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        trie.dfs("", stack, results, words[0].length());

        return results;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.wordSquares(new String[]{"area","lead","wall","lady","ball"});
    }
}

