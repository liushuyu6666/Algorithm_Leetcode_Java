package Map_Sum_Pairs;

import java.util.HashMap;
import java.util.HashSet;

class MapSum {
    TrieNode root;
    HashSet<String> set;

    public MapSum() {
        this.root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode curr = this.root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (curr.childNode[c - 'a'] == null) {
                curr.childNode[c - 'a'] = new TrieNode();
            }
            curr.map.put(key, val);
            curr = curr.childNode[c - 'a'];
        }
        curr.map.put(key, val);
    }

    public int sum(String prefix) {
        TrieNode curr = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.childNode[c - 'a'] == null) return 0;
            curr = curr.childNode[c - 'a'];
        }
        return curr.getSum();
    }
}

class TrieNode {
    TrieNode[] childNode;
    HashMap<String, Integer> map;

    TrieNode() {
        this.childNode = new TrieNode[26];
        this.map = new HashMap<>();
    }

    public int getSum() {
        int sum = 0;
        for(String key : map.keySet()) {
            sum += map.get(key);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
