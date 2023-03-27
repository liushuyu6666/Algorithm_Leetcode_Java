package Longest_Common_Prefix;

import java.util.ArrayList;

class LongestCommonPrefix {
    public String getLongestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) {
            if (str.equals("")) return "";
            trie.insertWord(str);
        }

        StringBuilder sb = new StringBuilder();

        trie.traverse(trie.root, sb);

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings;
        LongestCommonPrefix lcp = new LongestCommonPrefix();

        strings = new String[]{"flower", "flow", "flight"};
        System.out.println(lcp.getLongestCommonPrefix(strings));

        strings = new String[]{"dog", "racecar", "car"};
        System.out.println(lcp.getLongestCommonPrefix(strings));

        strings = new String[]{"b", ""};
        System.out.println(lcp.getLongestCommonPrefix(strings));

        strings = new String[]{"ab", "a"};
        System.out.println(lcp.getLongestCommonPrefix(strings));
    }
}

class Trie {
    TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.childNode[c - 'a'] == null) {
                curr.childNode[c - 'a'] = new TrieNode();
            }
            curr = curr.childNode[c - 'a'];
        }
        curr.isEnd = true;
    }

    private int getOnlyChild(TrieNode curr) {
        int existingChild = -1;
        for (int i = 0; i < 26; i++) {
            if (curr.childNode[i] != null) {
                if (existingChild != -1) return -1;
                existingChild = i;
            }
        }
        return existingChild;
    }

    public void traverse(TrieNode curr, StringBuilder sb) {
        if (curr.isEnd) return;
        int onlyChild = this.getOnlyChild(curr);
        if (onlyChild != -1) {
            char c = (char) ((char) onlyChild + 'a');
            sb.append(c);
            traverse(curr.childNode[onlyChild], sb);
        }
    }
}

class TrieNode {
    TrieNode[] childNode;
    boolean isEnd;

    TrieNode() {
        this.childNode = new TrieNode[26];
        this.isEnd = false;
    }
}
