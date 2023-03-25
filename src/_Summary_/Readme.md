# Tree

`Tree` consists of nodes.
```java
class Node {
    Node[] childNode;
    // its special values

    Node() {
        this.children = new TrieNode[26];
        // initialize the value
    }
}
```
We always build the tree from its root.
```java
Node root = new Node();
```
Note that when initializing the `Tree`, we only initialize the root node and not its child nodes. This allows the JVM 
to allocate space for the child nodes, but `root.childNodes` remains null. As we extend the `Tree`, we initialize one of 
its child nodes and move the current pointer (curr) to this child node.
```java
Node curr = root;
if (curr.childNode[i] == null) {
    curr.childNode[i] = new Node();
    curr = curr.childNode[i];
}
```
So the process shows on the illustration:![tree process.png](img%2Ftree%20process.png) 
We can see the current node always has allocated child nodes but the value is null.

