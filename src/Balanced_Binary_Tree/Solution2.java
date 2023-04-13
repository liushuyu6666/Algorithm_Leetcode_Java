package Balanced_Binary_Tree;

public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        return this.getDepth(root) != -1;
    }

    public int getDepth(TreeNode curr) {
        if(curr == null) return 0;
        int left = this.getDepth(curr.left);
        if(left == -1) return -1;
        int right = this.getDepth(curr.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
