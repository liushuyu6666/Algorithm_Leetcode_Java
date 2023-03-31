# Note of Implement Magic Dictionary

## Trie
Nothing surprising in normal method.

## Trie and DFS

**debug**:  
It failed when reached this case
```text
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello","hallo","leetcode"]], ["hello"], ["hallo"], ["hell"], ["leetcoded"]]
```
The output is
```text
[null,null,true,false,false,false]
```
and the expect should be
```text
[null,null,true,true,false,false]
```
So, the word "hallo" gets a wrong result.  
It is noteworthy that its equivalent word "hello" gives a right answer. **Returning the final result prematurely without 
traversing all possibilities** seems to be the root cause of the issue.