# Note of Word Search
## dfs

We cannot use `memo` to optimize if since the `isOccupied` is not always the same.
**Caveat**: It is important to note one caveat: make sure to reverse the values in the `map` accordingly.