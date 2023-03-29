package Design_Add_and_Search_Words_Data_Structure;
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
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
        return dfs(this.root, word, 0);
    }

    public boolean dfs(TrieNode curr, String word, int index) {
        if (index >= word.length()) return curr.isWord;

        char c = word.charAt(index);
        if (c != '.') {
            if (curr.childNode[c - 'a'] == null) return false;
            curr = curr.childNode[c - 'a'];
            return dfs(curr, word, index + 1);
        } else {
            boolean val = false;
            for (int i = 0; i < 26; i++) {
                if (curr.childNode[i] != null) {
                    // Caveat: don't move the curr pointer, curr = curr.childNode[i] is wrong.gi
                    val |= dfs(curr.childNode[i], word, index + 1);
                    if (val) return true;
                }
            }
            return false;
        }
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

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
