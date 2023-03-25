# Trie
To solve this problem, we need to build a `Trie` data structure. `Trie` consists of `TrieNodes`, which contain child nodes and 
values. Each `TrieNode` has 26 child nodes, representing letters, and a value `isWord` indicating if the node and its prefix 
form a word.  
For example, the `Trie` of word `tea` is like this: ![tea.png](tea.png)

