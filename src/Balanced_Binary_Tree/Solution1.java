package Balanced_Binary_Tree;

import java.util.HashMap;

public class Solution1 {
    HashMap<TreeNode, Integer> memo;

    public boolean isBalanced(TreeNode root) {
        memo = new HashMap<>();
        if(root == null) return false;
        if(this.isBalanced(root.left)) return true;
        if(this.isBalanced(root.right)) return true;
        int leftDepth = this.getDepth(root.left, memo), rightDepth = getDepth(root.right, memo);
        return Math.abs(leftDepth - rightDepth) >= 2;
    }

    public int getDepth(TreeNode curr, HashMap<TreeNode, Integer> memo) {
        if(curr == null) return 0;
        if(memo.containsKey(curr)) {
            System.out.println(curr.val);
            return memo.get(curr);
        }
        int depth = Math.max(1 + this.getDepth(curr.left, memo), 1 + this.getDepth(curr.right, memo));
        memo.put(curr, depth);
        return depth;
    }
}
