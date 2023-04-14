package Lowest_Common_Ancestor_of_a_Binary_Tree;

import java.util.Stack;

public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        if(!this.fds(root, p, pStack) || !this.fds(root, q, qStack)) {
            return null;
        }

        int i = 0, j = 0;
        while(i < pStack.size() && j < qStack.size()) {
            TreeNode pCurr = pStack.get(i);
            TreeNode qCurr = qStack.get(i);
            if(pCurr != qCurr) {
                return pStack.get(i-1);
            }
            i++;
            j++;
        }

        return pStack.get(i-1);
    }

    public boolean fds(TreeNode curr, TreeNode target, Stack<TreeNode> stack) {
        if(curr == null) return false;
        stack.push(curr);
        if(curr == target) return true;
        boolean flag = fds(curr.left, target, stack) || fds(curr.right, target, stack);
        if(flag) return true;
        stack.pop();
        return false;
    }
}
