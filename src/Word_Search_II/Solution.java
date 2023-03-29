package Word_Search_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for(String w : words) {
            trie.insertWord(w);
        }

        int X = board.length;
        int Y = board[0].length;
        StringBuilder stack = new StringBuilder();
        boolean[][] taken = new boolean[X][Y];
        HashSet<String> results = new HashSet<>();
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                taken[x][y] = false;
            }
        }

        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                dfs(board, x, y, trie.root, stack, taken, results);
            }
        }

        return new ArrayList<String>(results);
    }

    public void dfs(char[][] board, int x, int y, TrieNode curr, StringBuilder stack, boolean[][] taken, HashSet<String> results) {
        int X = board.length;
        int Y = board[0].length;

        // Check if went out of region
        if (x < 0 || y < 0 || x >= X || y >= Y) {
            return;
        }

        // Check if the position was taken
        if (taken[x][y]) {
            return;
        }

        char c = board[x][y];
        if (curr.childNode[c - 'a'] != null) {
            stack.append(c);
            taken[x][y] = true;
            curr = curr.childNode[c - 'a'];
            if (curr.isWord) {
                results.add(stack.toString());
            }

            // left
            dfs(board, x, y-1, curr, stack, taken, results);

            // right
            dfs(board, x, y+1, curr, stack, taken, results);

            // up
            dfs(board, x-1, y, curr, stack, taken, results);

            // down
            dfs(board, x+1, y, curr, stack, taken, results);

            stack.deleteCharAt(stack.length() - 1);
            taken[x][y] = false;
        } else {
            return;
        }
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
