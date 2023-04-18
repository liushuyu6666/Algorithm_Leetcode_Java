package Postorder_of_Binary_Search_Tree;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }
    // l inclusive, r exclusive
    public boolean dfs(int[] postorder, int l, int r) {
        int sep = 0;
        int i;
        if(l >= r) return true;
        for(i = l; i < r; i++) {
            if(postorder[i] > postorder[r]) {
                sep = i;
                break;
            };
        }
        if(i == r) {
            return dfs(postorder, l, r-1);
        }
        // Make sure right side of this sep are larger
        for(i = sep; i < r; i++) {
            if(postorder[i] < postorder[r]) return false;
        }
        return dfs(postorder, l, sep) & dfs(postorder, sep, r - 1);
    }
}
