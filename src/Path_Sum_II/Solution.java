package Path_Sum_II;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prefix = new ArrayList<Integer>();
        dfs(root, prefix, targetSum, ans);
        return ans;
    }

    public void dfs(TreeNode curr, List<Integer> prefix, int targetSum, List<List<Integer>> ans) {
        if(curr == null) return;
        prefix.add(curr.val);
        if(isLeaf(curr)) {
            if(sumUp(prefix) == targetSum) {
                List<Integer> temp = new ArrayList<>(prefix);
                ans.add(temp);
            }
            prefix.remove(prefix.size() - 1);
            return;
        }
        dfs(curr.left, prefix, targetSum, ans);
        dfs(curr.right, prefix, targetSum, ans);
        prefix.remove(prefix.size() - 1);
        return;
    }

    public int sumUp(List<Integer> prefix) {
        int sum = 0;
        for(int num : prefix) {
            sum += num;
        }
        return sum;
    }

    public boolean isLeaf(TreeNode curr) {
        return curr.left == null && curr.right == null;
    }
}
