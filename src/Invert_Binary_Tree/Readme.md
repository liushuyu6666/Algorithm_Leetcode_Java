# Note of Invert Binary Tree
## dfs
To effectively tackle this problem, we can utilize the `dfs` approach. By breaking down the problem systematically, 
we can define a dfs function that swaps the `root.left` and `root.right`. Prior to the swap, both `root.left` and `root.right` 
should be passed into the `dfs` function to swap their respective left and right children.
