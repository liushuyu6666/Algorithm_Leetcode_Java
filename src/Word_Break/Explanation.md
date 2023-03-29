# Note of Word Break
## Dynamic Programming
This is a 1-D dynamic programming question, although it involves a string.  
In the code `dp[x]` represents if `s.substring(0, x)` could be broken.  
We also have `dp[x] = dp[t] && isWord(s.substring(t, x))`

## Dynamic Programming with Knapsack
Optimize the algorithm by using a knapsack approach instead of moving the pointer `j` one grid at a time in the range 
`[0, i)`. `dp[i]` will only be set to true if `s.substring(j, i)` is a word in `wordDict`.  
![knapsack.png](knapsack.png)

## DFS (need to update after fully understand DFS)
![DFS&BFS.png](DFS%26BFS.png)
We can mentally construct a tree based on the positions of the separators in the string when using DFS or BFS. Each node 
in the tree represents a separator's position in the string. For example, if we traverse the path `0 -> 1 -> 3` in the tree, 
it means that we split the original string into two parts: `s.substring(0, 1)` and `s.substring(1, 3)`.  

This tree helps us to explore all possible combinations of substrings, but not all of them are valid. There is a criterion 
to check the validation of a certain node and only when the node is valid, we can step further. If we can reach a leaf 
node without passing through any invalid nodes, the word can be broken properly. Otherwise, the word cannot be broken.

To clarify it, let us think about a normal DFS:
```java
public void dfs(Node curr) {
    for (int i = 0; i < childNumber; i++) {
        if (curr.childNode[i] != null) {
            dfs(curr.childNode[i]);
        }
    }
}
```
But there are two different criteria in this specific question.
1. Instead of checking the existence of its child node, we check if `wordDict.contains(s.substring(curr, i))` is true.
2. Notice that there are some nodes sharing the same number, because the validation of the node depends on if `s.substring(0, i)` 
can be broken or not. Nodes with the same number must have the same validation. So, we could store the validation in the
`memo` to avoid duplicated traverse.


## BFS (need to update after fully understand DFS)
Almost the same as DFS, but the `memo` is slightly different. For these node that already popped out, we need to store it
to show that it was visited and do not need to visit again.

