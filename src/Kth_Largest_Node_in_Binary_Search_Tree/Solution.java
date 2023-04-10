package Kth_Largest_Node_in_Binary_Search_Tree;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    Stack<Integer> stack;
    public int kthLargest(TreeNode root, int k) {
        stack = new Stack<Integer>();
        dfs(root, k);
        return stack.pop();
    }

    public void dfs(TreeNode curr, int k) {
        if(curr == null) return;
        dfs(curr.right, k);
        if(stack.size() < k) {
            stack.push(curr.val);
        } else {
            return;
        }
        dfs(curr.left, k);
    }
}
