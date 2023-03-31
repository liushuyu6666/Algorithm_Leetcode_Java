package Implement_Magic_Dictionary;

class MagicDictionaryDFS {
    TrieNodeNew root;

    public MagicDictionaryDFS() {
        this.root = new TrieNodeNew();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNodeNew curr = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (curr.childNode[c - 'a'] == null) {
                    curr.childNode[c - 'a'] = new TrieNodeNew();
                }
                curr = curr.childNode[c - 'a'];
            }
            curr.isWord = true;
        }
    }

    public boolean search(String searchWord) {
        return dfs(searchWord, 0, this.root, 1);
    }

    public boolean dfs(String s, int currIndex, TrieNodeNew currNode, int limit) {
        if (limit < 0) return false;
        if (currIndex == s.length()) {
            return currNode.isWord && limit == 0;
        }

        char c = s.charAt(currIndex);

        boolean finalResult;

        for (int i = 0; i < 26; i++) {
            if(currNode.childNode[i] != null) {
                if (c - 'a' == i) {
                    // Caveat: return dfs(s, currIndex + 1, currNode.childNode[i], limit);
                    // We should not return the final answer now.
                    finalResult = dfs(s, currIndex + 1, currNode.childNode[i], limit);
                } else {
                    // Caveat: return dfs(s, currIndex + 1, currNode.childNode[i], limit - 1);
                    // We should not return the final answer now.
                    finalResult = dfs(s, currIndex + 1, currNode.childNode[i], limit - 1);
                }
                if (finalResult) return true;
            }
        }
        return false;
    }
}

class TrieNodeNew {
    TrieNodeNew[] childNode;
    boolean isWord;

    TrieNodeNew() {
        this.childNode = new TrieNodeNew[26];
        this.isWord = false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
