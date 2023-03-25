package Stream_of_Characters;

import Regular_Expression_Matching.RegularExpressionMatching;

public class StreamChecker {
    PathTrie pt = new PathTrie();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (String w : words) {
            pt.insertWord(w);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return pt.findWord(sb);
    }

    public static void main(String[] args) {
        String[] str = {"cd", "f", "kl"};
        StreamChecker streamChecker = new StreamChecker(str);
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println(streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));
        System.out.println(streamChecker.query('f'));
        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));

        Integer[] arr = new Integer[3];
        if (arr[1] == null) System.out.println("null");
        else System.out.println("not");
    }
}

class PathTrie {
    TrieNode root;

    PathTrie() {
        this.root = new TrieNode();
    }

    public void insertWord(String s) {
        TrieNode curr = this.root;

        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }

        curr.isWord = true;
    }

    public boolean findWord(StringBuilder sb) {
        TrieNode curr = this.root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (curr.children[c - 'a'] != null) {
                curr = curr.children[c - 'a'];
                if (curr.isWord) return true;
            } else {
                return false;
            }
        }
        return curr.isWord;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    TrieNode() {
        this.children = new TrieNode[26];
        isWord = false;
    }
}
